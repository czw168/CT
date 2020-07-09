/*    */ package cn.ubot.service.production.impl;
/*    */ import java.sql.Date;
/*    */ import java.util.List;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;

/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.github.pagehelper.PageInfo;

/*    */ 
/*    */ import cn.ubot.commin.AjaxResult;
/*    */ import cn.ubot.commin.DateUtil;
/*    */ import cn.ubot.commin.EUDataGridResult;
/*    */ import cn.ubot.commin.ExceptionUtil;
/*    */ import cn.ubot.mapper.diy.production.LtcMapper_;
/*    */ import cn.ubot.mapper.generator.LtcMapper;
/*    */ import cn.ubot.pojo.diy.production.Ltc_;
/*    */ import cn.ubot.pojo.generator.Ltc;
/*    */ import cn.ubot.service.production.LTCService;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class LTCServiceImpl
/*    */   implements LTCService
/*    */ {
/*    */   @Autowired
/*    */   private LtcMapper_ ltcMapper_;
/*    */   @Autowired
/*    */   private LtcMapper ltcMapper;
/*    */   
/*    */   public EUDataGridResult listLTC(Integer page, Integer rows, String ltc) {
/* 31 */     EUDataGridResult result = new EUDataGridResult();
/* 32 */     PageHelper.startPage(page.intValue(), rows.intValue());
/* 33 */     List<Ltc_> ltcList = this.ltcMapper_.listLtc(ltc);
/* 34 */     result.setRows(ltcList);
/*    */     
/* 36 */     PageInfo<Ltc_> pageInfo = new PageInfo<Ltc_>(ltcList);
/* 37 */     result.setTotal(pageInfo.getTotal());
/* 38 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AjaxResult newLTC(Ltc ltc) {
/* 44 */     java.util.Date productionDate = ltc.getProductionDate();
/*    */     try {
/* 46 */       String yy = DateUtil.format(productionDate, "yy");
/* 47 */       String mm = null;
/* 48 */       int month = DateUtil.getMonth(productionDate);
/* 49 */       if (month == 10) {
/* 50 */         mm = "X";
/* 51 */       } else if (month == 11) {
/* 52 */         mm = "Y";
/* 53 */       } else if (month == 12) {
/* 54 */         mm = "Z";
/*    */       } else {
/* 56 */         mm = month + "";
/*    */       } 
/* 58 */       String dd = DateUtil.format(productionDate, "dd");
/* 59 */       String ltcNo = ltc.getSourceBatchCode() + ltc.getLotType() + ltc.getProductType() + yy + mm + dd + ltc.getLotSerics() + ltc.getSublotSerics();
/* 60 */       ltc.setLtc(ltcNo);
/* 61 */       ltc.setCreateTime(new Date(System.currentTimeMillis()));
/* 62 */       this.ltcMapper.insertSelective(ltc);
/* 63 */     } catch (Exception e) {
/* 64 */       e.printStackTrace();
/* 65 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*    */     } 
/* 67 */     return AjaxResult.ok();
/*    */   }
/*    */ 
/*    */   
/*    */   public AjaxResult updateLTC(Ltc ltc) {
/* 72 */     ltc.setUpdateTime(new Date(System.currentTimeMillis()));
/*    */     try {
/* 74 */       this.ltcMapper.updateByPrimaryKeySelective(ltc);
/* 75 */     } catch (Exception e) {
/* 76 */       e.printStackTrace();
/* 77 */       AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*    */     } 
/* 79 */     return AjaxResult.ok();
/*    */   }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\impl\LTCServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */