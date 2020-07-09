/*     */ package cn.ubot.service.production.impl;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.ExceptionUtil;
/*     */ import cn.ubot.mapper.diy.production.PackingLabelMapper_;
/*     */ import cn.ubot.mapper.generator.PackingLabelMapper;
/*     */ import cn.ubot.mapper.generator.ReelLabelLotMapper;
/*     */ import cn.ubot.pojo.diy.production.PackingLtc;
/*     */ import cn.ubot.pojo.generator.PackingLabel;
/*     */ import cn.ubot.pojo.generator.PackingLabelExample;
/*     */ import cn.ubot.pojo.generator.ReelLabelLot;
/*     */ import cn.ubot.pojo.generator.ReelLabelLotExample;
/*     */ import cn.ubot.service.production.PackingLabelService;
/*     */ import com.alibaba.druid.util.StringUtils;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import java.sql.Date;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class PackingLabelServiceImpl
/*     */   implements PackingLabelService
/*     */ {
/*     */   @Autowired
/*     */   private PackingLabelMapper packingLabelMapper;
/*     */   @Autowired
/*     */   private PackingLabelMapper_ packingLabelMapper_;
/*     */   @Autowired
/*     */   private ReelLabelLotMapper reelLabelLotMapper;
/*     */   
/*     */   public AjaxResult getMaxCarton() {
/*  39 */     String maxCarton = this.packingLabelMapper_.getMaxCarton();
/*  40 */     if (StringUtils.isEmpty(maxCarton))
/*     */     {
/*  42 */       return AjaxResult.ok("P000000001");
/*     */     }
/*  44 */     String a = maxCarton.substring(0, 1);
/*  45 */     String b = maxCarton.substring(1);
/*  46 */     Integer num = Integer.valueOf(Integer.parseInt(b) + 1);
/*  47 */     NumberFormat nf = new DecimalFormat("000000000");
/*  48 */     String formatNum = nf.format(num);
/*     */     
/*  50 */     return AjaxResult.ok(a + formatNum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AjaxResult newPackingLabel(PackingLabel packingLabel) {
/*  57 */     if (packingLabel.getQ1().equals(packingLabel.getQ2()) || packingLabel.getQ1().equals(packingLabel.getQ3())) {
/*  58 */       return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ1() + "].");
/*     */     }
/*  60 */     if (packingLabel.getQ2().equals(packingLabel.getQ3())) {
/*  61 */       return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ2() + "].");
/*     */     }
/*     */ 
/*     */     
/*  65 */     ReelLabelLotExample example = new ReelLabelLotExample();
/*  66 */     ReelLabelLotExample.Criteria criteria = example.createCriteria();
/*  67 */     criteria.andLotNoEqualTo(packingLabel.getQ1());
/*  68 */     List<ReelLabelLot> list1 = this.reelLabelLotMapper.selectByExample(example);
/*  69 */     if (list1.size() == 0) {
/*  70 */       return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ1() + "] is not exist.");
/*     */     }
/*     */     
/*  73 */     ReelLabelLotExample example2 = new ReelLabelLotExample();
/*  74 */     ReelLabelLotExample.Criteria criteria2 = example2.createCriteria();
/*  75 */     criteria2.andLotNoEqualTo(packingLabel.getQ2());
/*  76 */     List<ReelLabelLot> list2 = this.reelLabelLotMapper.selectByExample(example2);
/*  77 */     if (list2.size() == 0) {
/*  78 */       return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ2() + "] is not exist.");
/*     */     }
/*     */     
/*  81 */     ReelLabelLotExample example3 = new ReelLabelLotExample();
/*  82 */     ReelLabelLotExample.Criteria criteria3 = example3.createCriteria();
/*  83 */     criteria3.andLotNoEqualTo(packingLabel.getQ3());
/*  84 */     List<ReelLabelLot> list3 = this.reelLabelLotMapper.selectByExample(example3);
/*  85 */     if (list3.size() == 0) {
/*  86 */       return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ3() + "] is not exist.");
/*     */     }
/*     */ 
/*     */     
/*  90 */     PackingLabelExample packingLabelExample = new PackingLabelExample();
/*  91 */     List<PackingLabel> packingLabelList = this.packingLabelMapper.selectByExample(packingLabelExample);
/*  92 */     for (PackingLabel pl : packingLabelList) {
/*  93 */       if (pl.getQ1().equals(packingLabel.getQ1()) || pl.getQ2().equals(packingLabel.getQ1()) || pl.getQ3().equals(packingLabel.getQ1())) {
/*  94 */         return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ1() + "] <br> has been scanned.");
/*     */       }
/*  96 */       if (pl.getQ1().equals(packingLabel.getQ2()) || pl.getQ2().equals(packingLabel.getQ2()) || pl.getQ3().equals(packingLabel.getQ2())) {
/*  97 */         return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ2() + "] <br> has been scanned.");
/*     */       }
/*  99 */       if (pl.getQ1().equals(packingLabel.getQ3()) || pl.getQ2().equals(packingLabel.getQ3()) || pl.getQ3().equals(packingLabel.getQ3())) {
/* 100 */         return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ3() + "] <br> has been scanned.");
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 105 */     packingLabel.setCreateTime(new Date(System.currentTimeMillis()));
/*     */     try {
/* 107 */       this.packingLabelMapper.insertSelective(packingLabel);
/* 108 */       return AjaxResult.ok();
/* 109 */     } catch (Exception e) {
/* 110 */       e.printStackTrace();
/* 111 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EUDataGridResult getPackingLabelList(Integer page, Integer rows, String carton, String lotNo) {
/* 118 */     EUDataGridResult result = new EUDataGridResult();
/* 119 */     PageHelper.startPage(page.intValue(), rows.intValue());
/* 120 */     List<PackingLtc> packingLtcList = this.packingLabelMapper_.getPackingLtc(carton, lotNo);
/* 121 */     result.setRows(packingLtcList);
/*     */     
/* 123 */     PageInfo<PackingLtc> pageInfo = new PageInfo<PackingLtc>(packingLtcList);
/* 124 */     result.setTotal(pageInfo.getTotal());
/* 125 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AjaxResult updatePackingLabel(PackingLabel packingLabel) {
/* 132 */     if (packingLabel.getQ1().equals(packingLabel.getQ2()) || packingLabel.getQ1().equals(packingLabel.getQ3())) {
/* 133 */       return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ1() + "].");
/*     */     }
/* 135 */     if (packingLabel.getQ2().equals(packingLabel.getQ3())) {
/* 136 */       return AjaxResult.build(Integer.valueOf(400), "Duplicat Lot No : [" + packingLabel.getQ2() + "].");
/*     */     }
/*     */ 
/*     */     
/* 140 */     ReelLabelLotExample example = new ReelLabelLotExample();
/* 141 */     ReelLabelLotExample.Criteria criteria = example.createCriteria();
/* 142 */     criteria.andLotNoEqualTo(packingLabel.getQ1());
/* 143 */     List<ReelLabelLot> list1 = this.reelLabelLotMapper.selectByExample(example);
/* 144 */     if (list1.size() == 0) {
/* 145 */       return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ1() + "] is not exist.");
/*     */     }
/*     */     
/* 148 */     ReelLabelLotExample example2 = new ReelLabelLotExample();
/* 149 */     ReelLabelLotExample.Criteria criteria2 = example2.createCriteria();
/* 150 */     criteria2.andLotNoEqualTo(packingLabel.getQ2());
/* 151 */     List<ReelLabelLot> list2 = this.reelLabelLotMapper.selectByExample(example2);
/* 152 */     if (list2.size() == 0) {
/* 153 */       return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ2() + "] is not exist.");
/*     */     }
/*     */     
/* 156 */     ReelLabelLotExample example3 = new ReelLabelLotExample();
/* 157 */     ReelLabelLotExample.Criteria criteria3 = example3.createCriteria();
/* 158 */     criteria3.andLotNoEqualTo(packingLabel.getQ3());
/* 159 */     List<ReelLabelLot> list3 = this.reelLabelLotMapper.selectByExample(example3);
/* 160 */     if (list3.size() == 0) {
/* 161 */       return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ3() + "] is not exist.");
/*     */     }
/*     */ 
/*     */     
/* 165 */     PackingLabel packingLabel2 = this.packingLabelMapper.selectByPrimaryKey(packingLabel.getId());
/*     */     
/* 167 */     PackingLabelExample packingLabelExample = new PackingLabelExample();
/* 168 */     List<PackingLabel> packingLabelList = this.packingLabelMapper.selectByExample(packingLabelExample);
/*     */ 
/*     */     
/* 171 */     if (!packingLabel.getQ1().equals(packingLabel2.getQ1()))
/*     */     {
/* 173 */       for (PackingLabel pl : packingLabelList) {
/* 174 */         if (pl.getQ1().equals(packingLabel.getQ1()) || pl.getQ2().equals(packingLabel.getQ1()) || pl.getQ3().equals(packingLabel.getQ1())) {
/* 175 */           return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ1() + "] <br> has been scanned.");
/*     */         }
/*     */       } 
/*     */     }
/* 179 */     if (!packingLabel.getQ2().equals(packingLabel2.getQ2()))
/*     */     {
/* 181 */       for (PackingLabel pl : packingLabelList) {
/* 182 */         if (pl.getQ1().equals(packingLabel.getQ2()) || pl.getQ2().equals(packingLabel.getQ2()) || pl.getQ3().equals(packingLabel.getQ2())) {
/* 183 */           return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ2() + "] <br> has been scanned.");
/*     */         }
/*     */       } 
/*     */     }
/* 187 */     if (!packingLabel.getQ3().equals(packingLabel2.getQ3()))
/*     */     {
/* 189 */       for (PackingLabel pl : packingLabelList) {
/* 190 */         if (pl.getQ1().equals(packingLabel.getQ3()) || pl.getQ2().equals(packingLabel.getQ3()) || pl.getQ3().equals(packingLabel.getQ3())) {
/* 191 */           return AjaxResult.build(Integer.valueOf(400), "Lot No : [" + packingLabel.getQ3() + "] <br> has been scanned.");
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 197 */     packingLabel.setUpdateTime(new Date(System.currentTimeMillis()));
/*     */     try {
/* 199 */       this.packingLabelMapper.updateByPrimaryKeySelective(packingLabel);
/* 200 */       return AjaxResult.ok();
/* 201 */     } catch (Exception e) {
/* 202 */       e.printStackTrace();
/* 203 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\impl\PackingLabelServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */