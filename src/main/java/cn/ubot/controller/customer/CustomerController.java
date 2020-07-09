/*     */ package cn.ubot.controller.customer;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUComboBoxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.JsonUtils;
/*     */ import cn.ubot.pojo.generator.CustomerInfo;
/*     */ import cn.ubot.pojo.generator.CustomerPn;
/*     */ import cn.ubot.service.customer.CustomerInfoService;
/*     */ import cn.ubot.service.customer.CustomerPNService;
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
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/customer"})
/*     */ public class CustomerController
/*     */ {
/*     */   @Autowired
/*     */   private CustomerInfoService customerInfoService;
/*     */   @Autowired
/*     */   private CustomerPNService customerPNService;
/*     */   
/*     */   @RequestMapping({"/{page}"})
/*  43 */   public String showPage(@PathVariable String page) { return "/customer/" + page; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listCustomerInfo"})
/*     */   @ResponseBody
/*  55 */   EUDataGridResult listCustomerInfo(Integer page, Integer rows) { return this.customerInfoService.listCustomerInfo(page, rows); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addCustomerInfo"})
/*     */   @ResponseBody
/*     */   AjaxResult addCustomerInfo(@RequestBody JSONObject obj) {
/*  66 */     CustomerInfo customerInfo = (CustomerInfo)JsonUtils.jsonToPojo(obj.toJSONString(), CustomerInfo.class);
/*  67 */     return this.customerInfoService.addCustomerInfo(customerInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/updateCustomerInfo"})
/*     */   @ResponseBody
/*     */   AjaxResult updateCustomerInfo(@RequestBody JSONObject obj) {
/*  78 */     CustomerInfo customerInfo = (CustomerInfo)JsonUtils.jsonToPojo(obj.toJSONString(), CustomerInfo.class);
/*  79 */     return this.customerInfoService.updateCustomerInfo(customerInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/getCustomerName"})
/*     */   @ResponseBody
/*  89 */   List<EUComboBoxResult> getCustomerName() { return this.customerInfoService.getCustomerName(); }
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
/*     */   @GetMapping({"/listCustomerPn"})
/*     */   @ResponseBody
/* 103 */   EUDataGridResult listCustomerPn(Integer page, Integer rows) { return this.customerPNService.listCustomerPn(page, rows); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addCustomerPn"})
/*     */   @ResponseBody
/*     */   AjaxResult addCustomerPn(@RequestBody JSONObject obj) {
/* 114 */     CustomerPn customerPn = (CustomerPn)JsonUtils.jsonToPojo(obj.toJSONString(), CustomerPn.class);
/* 115 */     return this.customerPNService.addCustomerPn(customerPn);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/updateCustomerPn"})
/*     */   @ResponseBody
/*     */   AjaxResult updateCustomerPn(@RequestBody JSONObject obj) {
/* 125 */     CustomerPn customerPn = (CustomerPn)JsonUtils.jsonToPojo(obj.toJSONString(), CustomerPn.class);
/* 126 */     return this.customerPNService.updateCustomerPn(customerPn);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/getCustomerInfo"})
/*     */   @ResponseBody
/*     */   AjaxResult getCustomerInfo(@RequestBody JSONObject obj) {
/* 136 */     CustomerPn customerPn = (CustomerPn)JsonUtils.jsonToPojo(obj.toJSONString(), CustomerPn.class);
/* 137 */     return this.customerPNService.getCustomerInfo(customerPn);
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\controller\customer\CustomerController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */