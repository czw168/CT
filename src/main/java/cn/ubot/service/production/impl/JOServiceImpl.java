/*     */ package cn.ubot.service.production.impl;
/*     */ import java.sql.Date;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;

/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.github.pagehelper.PageInfo;

/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.DateUtil;
/*     */ import cn.ubot.commin.EUDataGridFootResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.ExceptionUtil;
/*     */ import cn.ubot.mapper.diy.production.JoMapper_;
/*     */ import cn.ubot.mapper.generator.JoMapper;
/*     */ import cn.ubot.pojo.diy.production.Jo_;
/*     */ import cn.ubot.pojo.generator.Jo;
/*     */ import cn.ubot.service.production.JOService;
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class JOServiceImpl
/*     */   implements JOService
/*     */ {
/*     */   @Autowired
/*     */   private JoMapper_ JoMapper_;
/*     */   @Autowired
/*     */   private JoMapper joMapper;
/*     */   
/*     */   public EUDataGridResult listJO(Integer page, Integer rows, String joNo) {
/*  37 */     EUDataGridResult result = new EUDataGridResult();
/*  38 */     PageHelper.startPage(page.intValue(), rows.intValue());
/*  39 */     List<Jo_> joList = this.JoMapper_.listJo(joNo);
/*  40 */     result.setRows(joList);
/*     */     
/*  42 */     PageInfo<Jo_> pageInfo = new PageInfo<Jo_>(joList);
/*  43 */     result.setTotal(pageInfo.getTotal());
/*  44 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult getMaxJoNo() {
/*  49 */     String joNo = null;
/*     */     
/*  51 */     Integer year = Integer.valueOf(DateUtil.getYear(new java.util.Date()));
/*  52 */     String maxJoNo = this.JoMapper_.getMaxJoNo();
/*  53 */     if (null == maxJoNo) {
/*     */       
/*  55 */       joNo = "V01JC" + year + "-00001";
/*     */     } else {
/*     */       
/*  58 */       CharSequence y = year + "";
/*  59 */       if (maxJoNo.contains(y)) {
/*     */         
/*  61 */         String substringNum = maxJoNo.substring(10);
/*  62 */         Integer num = Integer.valueOf(Integer.parseInt(substringNum) + 1);
/*  63 */         NumberFormat nf = new DecimalFormat("00000");
/*  64 */         String formatNum = nf.format(num);
/*  65 */         joNo = "V01JC" + year + "-" + formatNum;
/*     */       } else {
/*     */         
/*  68 */         joNo = "V01JC" + year + "-00001";
/*     */       } 
/*     */     } 
/*  71 */     return AjaxResult.ok(joNo);
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult newJO(List<Jo> listJo) {
/*     */     try {
/*  77 */       for (int i = 0; i < listJo.size(); i++) {
/*  78 */         Jo jo = (Jo)listJo.get(i);
/*  79 */         Date currentDate = new Date(System.currentTimeMillis());
/*  80 */         jo.setCreateTime(currentDate);
/*  81 */         jo.setItem(Integer.valueOf(i + 1));
/*     */         
/*  83 */         this.joMapper.insertSelective(jo);
/*     */       } 
/*  85 */     } catch (Exception e) {
/*  86 */       e.printStackTrace();
/*  87 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/*  89 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public EUDataGridFootResult listDetailsJO(Integer page, Integer rows, String joNo) {
/*  94 */     EUDataGridFootResult result = new EUDataGridFootResult();
/*  95 */     PageHelper.startPage(page.intValue(), rows.intValue());
/*  96 */     List<Jo_> joDetailsList = this.JoMapper_.listDetailsJo(joNo);
/*  97 */     result.setRows(joDetailsList);
/*     */     
/*  99 */     PageInfo<Jo_> pageInfo = new PageInfo<Jo_>(joDetailsList);
/* 100 */     result.setTotal(pageInfo.getTotal());
/*     */     
/* 102 */     List<Map<String, Object>> footer = new ArrayList<Map<String, Object>>();
/* 103 */     Map<String, Object> map = new HashMap<String, Object>();
/* 104 */     map.put("uom", "Total:");
/* 105 */     map.put("orderQuantity", ((Jo_)joDetailsList.get(0)).getTotal());
/* 106 */     footer.add(map);
/* 107 */     result.setFooter(footer);
/* 108 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AjaxResult addJO(Jo jo) {
/*     */     try {
/* 147 */       Integer maxItem = this.JoMapper_.getMaxItem(jo.getUbotJo());
/* 148 */       if (null != maxItem) {
/* 149 */         jo.setItem(Integer.valueOf(maxItem.intValue() + 1));
/*     */       } else {
/* 151 */         jo.setItem(Integer.valueOf(1));
/*     */       } 
/* 153 */       jo.setCreateTime(new Date(System.currentTimeMillis()));
/* 154 */       this.joMapper.insertSelective(jo);
/* 155 */     } catch (Exception e) {
/* 156 */       e.printStackTrace();
/* 157 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 159 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult updateJO(Jo jo) {
/*     */     try {
/* 165 */       Date currentDate = new Date(System.currentTimeMillis());
/* 166 */       jo.setUpdateTime(currentDate);
/*     */       
/* 168 */       this.joMapper.updateByPrimaryKeySelective(jo);
/* 169 */     } catch (Exception e) {
/* 170 */       e.printStackTrace();
/* 171 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 173 */     return AjaxResult.ok();
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\impl\JOServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */