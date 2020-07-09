/*     */ package cn.ubot.service.production.impl;
/*     */ import java.sql.Date;
/*     */ import java.util.List;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;

/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.github.pagehelper.PageInfo;

/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.DateUtil;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.mapper.diy.production.ReelLabelMapper_;
/*     */ import cn.ubot.mapper.generator.ReelLabelLotMapper;
/*     */ import cn.ubot.mapper.generator.ReelLabelMapper;
/*     */ import cn.ubot.pojo.diy.production.ReelLabel_;
/*     */ import cn.ubot.pojo.generator.ReelLabel;
/*     */ import cn.ubot.pojo.generator.ReelLabelLot;
/*     */ import cn.ubot.pojo.generator.ReelLabelLotExample;
/*     */ import cn.ubot.service.production.ReelLabelService;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ReelLabelServiceImpl
/*     */   implements ReelLabelService
/*     */ {
/*     */   @Autowired
/*     */   private ReelLabelMapper reelLabelMapper;
/*     */   @Autowired
/*     */   private ReelLabelLotMapper reelLabelLotMapper;
/*     */   @Autowired
/*     */   private ReelLabelMapper_ reelLabelMapper_;
/*     */   
/*     */   public EUDataGridResult listReelLabel(Integer page, Integer rows, String ltc) {
/*  36 */     EUDataGridResult result = new EUDataGridResult();
/*  37 */     PageHelper.startPage(page.intValue(), rows.intValue());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     List<ReelLabel_> reelLabelList = this.reelLabelMapper_.getReelLabelList(ltc);
/*     */     
/*  47 */     result.setRows(reelLabelList);
/*     */     
/*  49 */     PageInfo<ReelLabel_> pageInfo = new PageInfo<ReelLabel_>(reelLabelList);
/*  50 */     result.setTotal(pageInfo.getTotal());
/*  51 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AjaxResult newReelLabel(ReelLabel reelLabel) {
/*     */     try {
/*  58 */       String lane = reelLabel.getLane();
/*     */       
/*  60 */       java.util.Date productionDate = reelLabel.getProductionDate();
/*  61 */       int month = DateUtil.getMonth(productionDate);
/*  62 */       String date = DateUtil.format(productionDate, "dd");
/*  63 */       int year = DateUtil.getYear(productionDate);
/*  64 */       String productionDate_ = (month < 10) ? ("0" + month) : ("" + month);
/*  65 */       productionDate_ = productionDate_ + date + year;
/*     */       
/*  67 */       ReelLabelLotExample example = new ReelLabelLotExample();
/*  68 */       ReelLabelLotExample.Criteria criteria = example.createCriteria();
/*  69 */       criteria.andProductionDateEqualTo(productionDate_);
/*  70 */       criteria.andLaneEqualTo(lane);
/*     */       
/*  72 */       List<ReelLabelLot> reelLabelLots = this.reelLabelLotMapper.selectByExample(example);
/*  73 */       if (!reelLabelLots.isEmpty()) {
/*  74 */         return AjaxResult.build(Integer.valueOf(400), "Fail. Duplicate Lot NO.");
/*     */       }
/*  76 */       for (int i = 0; i < reelLabel.getBatches().intValue(); i++) {
/*     */         
/*  78 */         String lotNo = null;
/*  79 */         if (i < 9) {
/*  80 */           lotNo = reelLabel.getMachine() + productionDate_ + "-0" + (i + 1) + lane;
/*     */         } else {
/*  82 */           lotNo = reelLabel.getMachine() + productionDate_ + "-" + (i + 1) + lane;
/*     */         } 
/*  84 */         ReelLabelLot rll = new ReelLabelLot();
/*  85 */         rll.setLane(lane);
/*  86 */         rll.setLotNo(lotNo);
/*  87 */         rll.setLtc(reelLabel.getLtc());
/*  88 */         rll.setMachine(reelLabel.getMachine());
/*  89 */         rll.setProductionDate(productionDate_);
/*     */         
/*  91 */         this.reelLabelLotMapper.insert(rll);
/*     */       } 
/*  93 */       reelLabel.setCreateTime(new Date(System.currentTimeMillis()));
/*  94 */       reelLabel.setStatus(Integer.valueOf(0));
/*  95 */       this.reelLabelMapper.insert(reelLabel);
/*  96 */     } catch (Exception e) {
/*  97 */       e.printStackTrace();
/*  98 */       return AjaxResult.build(Integer.valueOf(500), "Error");
/*     */     } 
/* 100 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult updateReelLabel(ReelLabel reelLabel, Integer batches) {
/*     */     try {
/* 106 */       PageHelper.startPage(1, 1);
/* 107 */       ReelLabelLotExample example = new ReelLabelLotExample();
/* 108 */       ReelLabelLotExample.Criteria criteria = example.createCriteria();
/* 109 */       criteria.andLtcEqualTo(reelLabel.getLtc());
/* 110 */       ReelLabelLot reelLabelLot = (ReelLabelLot)this.reelLabelLotMapper.selectByExample(example).get(0);
/*     */ 
/*     */       
/* 113 */       for (int i = reelLabel.getBatches().intValue() + 1; i <= batches.intValue(); i++) {
/* 114 */         ReelLabelLot rll = new ReelLabelLot();
/* 115 */         rll.setLane(reelLabelLot.getLane());
/* 116 */         if (i < 10) {
/* 117 */           rll.setLotNo(reelLabelLot.getMachine() + reelLabelLot.getProductionDate() + "-0" + i + reelLabelLot.getLane());
/*     */         } else {
/* 119 */           rll.setLotNo(reelLabelLot.getMachine() + reelLabelLot.getProductionDate() + "-" + i + reelLabelLot.getLane());
/*     */         } 
/* 121 */         rll.setLtc(reelLabelLot.getLtc());
/* 122 */         rll.setMachine(reelLabelLot.getMachine());
/* 123 */         rll.setProductionDate(reelLabelLot.getProductionDate());
/* 124 */         this.reelLabelLotMapper.insert(rll);
/*     */       } 
/*     */       
/* 127 */       reelLabel.setBatches(batches);
/* 128 */       reelLabel.setUpdateTime(new Date(System.currentTimeMillis()));
/* 129 */       this.reelLabelMapper.updateByPrimaryKeySelective(reelLabel);
/*     */     }
/* 131 */     catch (Exception e) {
/* 132 */       e.printStackTrace();
/* 133 */       return AjaxResult.build(Integer.valueOf(500), "Error");
/*     */     } 
/* 135 */     return AjaxResult.ok();
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\impl\ReelLabelServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */