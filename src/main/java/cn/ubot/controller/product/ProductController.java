/*     */ package cn.ubot.controller.product;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUComboBoxResult;
/*     */ import cn.ubot.commin.EUDataGridComboBoxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.JsonUtils;
/*     */ import cn.ubot.pojo.generator.ProductInfo;
/*     */ import cn.ubot.service.product.ProductService;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
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
/*     */ @Controller
/*     */ @RequestMapping({"/product/"})
/*     */ public class ProductController
/*     */ {
/*     */   @Autowired
/*     */   private ProductService productService;
/*     */   
/*     */   @RequestMapping({"/{page}"})
/*  38 */   public String showPage(@PathVariable String page) { return "/product/" + page; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listProduct"})
/*     */   @ResponseBody
/*  50 */   EUDataGridResult listProduct(Integer page, Integer rows) { return this.productService.listProduct(page, rows); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addProduct"})
/*     */   @ResponseBody
/*     */   AjaxResult addProduct(@RequestBody JSONObject obj) {
/*  61 */     ProductInfo productInfo = (ProductInfo)JsonUtils.jsonToPojo(obj.toJSONString(), ProductInfo.class);
/*  62 */     return this.productService.addProduct(productInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/updateProduct"})
/*     */   @ResponseBody
/*     */   AjaxResult updateProduct(@RequestBody JSONObject obj) {
/*  73 */     ProductInfo productInfo = (ProductInfo)JsonUtils.jsonToPojo(obj.toJSONString(), ProductInfo.class);
/*  74 */     return this.productService.updateProduct(productInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/getProductPn"})
/*     */   @ResponseBody
/*  84 */   List<EUComboBoxResult> getProductPn() { return this.productService.getProductPn(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/getProductPn_"})
/*     */   @ResponseBody
/*  94 */   List<EUDataGridComboBoxResult> getProductPn_() { return this.productService.getProductPn_(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/getRequirementByPn"})
/*     */   @ResponseBody
/* 105 */   AjaxResult getRequirementByPn(String pn) { return this.productService.getRequirementByPn(pn); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/getDwgNoByPn"})
/*     */   @ResponseBody
/*     */   AjaxResult getDwgNoByPn(@RequestBody JSONObject obj) {
/* 116 */     String pn = obj.getString("pn");
/* 117 */     return this.productService.getDwgNoByPn(pn);
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\controller\product\ProductController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */