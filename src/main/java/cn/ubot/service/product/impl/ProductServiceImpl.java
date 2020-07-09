/*     */ package cn.ubot.service.product.impl;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUComboBoxResult;
/*     */ import cn.ubot.commin.EUDataGridComboBoxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.ExceptionUtil;
/*     */ import cn.ubot.mapper.diy.product.ProductInfoMapper_;
/*     */ import cn.ubot.mapper.generator.ProductInfoMapper;
/*     */ import cn.ubot.pojo.generator.ProductInfo;
/*     */ import cn.ubot.pojo.generator.ProductInfoExample;
/*     */ import cn.ubot.service.product.ProductService;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ProductServiceImpl
/*     */   implements ProductService
/*     */ {
/*     */   @Autowired
/*     */   private ProductInfoMapper_ productInfoMapper_;
/*     */   @Autowired
/*     */   private ProductInfoMapper productInfoMapper;
/*     */   
/*     */   public EUDataGridResult listProduct(Integer page, Integer rows) {
/*  33 */     EUDataGridResult result = new EUDataGridResult();
/*  34 */     PageHelper.startPage(page.intValue(), rows.intValue());
/*  35 */     ProductInfoExample example = new ProductInfoExample();
/*  36 */     List<ProductInfo> productList = this.productInfoMapper.selectByExampleWithBLOBs(example);
/*  37 */     result.setRows(productList);
/*     */     
/*  39 */     PageInfo<ProductInfo> pageInfo = new PageInfo<ProductInfo>(productList);
/*  40 */     result.setTotal(pageInfo.getTotal());
/*  41 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult addProduct(ProductInfo productInfo) {
/*     */     try {
/*  47 */       productInfo.setStatus(Integer.valueOf(1));
/*  48 */       this.productInfoMapper.insert(productInfo);
/*  49 */     } catch (Exception e) {
/*  50 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/*  52 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult updateProduct(ProductInfo productInfo) {
/*     */     try {
/*  58 */       this.productInfoMapper.updateByPrimaryKey(productInfo);
/*  59 */     } catch (Exception e) {
/*  60 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/*  62 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EUComboBoxResult> getProductPn() {
/*  67 */     List<EUComboBoxResult> l = new ArrayList<EUComboBoxResult>();
/*  68 */     ProductInfoExample example = new ProductInfoExample();
/*  69 */     List<ProductInfo> productInfoList = this.productInfoMapper.selectByExample(example);
/*  70 */     for (ProductInfo productInfo : productInfoList) {
/*  71 */       if (productInfo.getStatus().intValue() == 1) {
/*  72 */         EUComboBoxResult eur2 = new EUComboBoxResult(productInfo.getPn(), productInfo.getPn(), null);
/*  73 */         l.add(eur2);
/*     */       } 
/*     */     } 
/*  76 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EUDataGridComboBoxResult> getProductPn_() {
/*  81 */     List<EUDataGridComboBoxResult> l = new ArrayList<EUDataGridComboBoxResult>();
/*  82 */     ProductInfoExample example = new ProductInfoExample();
/*  83 */     List<ProductInfo> productInfoList = this.productInfoMapper.selectByExample(example);
/*  84 */     for (ProductInfo productInfo : productInfoList) {
/*  85 */       if (productInfo.getStatus().intValue() == 1) {
/*  86 */         EUDataGridComboBoxResult eur2 = new EUDataGridComboBoxResult(productInfo.getPn(), productInfo.getPn());
/*  87 */         l.add(eur2);
/*     */       } 
/*     */     } 
/*  90 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  95 */   public AjaxResult getRequirementByPn(String pn) { return AjaxResult.ok(this.productInfoMapper_.getRequirementByPn(pn)); }
/*     */ 
/*     */ 
/*     */   
/*     */   public AjaxResult getDwgNoByPn(String pn) {
/* 100 */     ProductInfoExample example = new ProductInfoExample();
/* 101 */     ProductInfoExample.Criteria criteria = example.createCriteria();
/* 102 */     criteria.andPnEqualTo(pn);
/* 103 */     List<ProductInfo> productInfoList = this.productInfoMapper.selectByExample(example);
/* 104 */     return AjaxResult.ok(((ProductInfo)productInfoList.get(0)).getDwgNo());
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\product\impl\ProductServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */