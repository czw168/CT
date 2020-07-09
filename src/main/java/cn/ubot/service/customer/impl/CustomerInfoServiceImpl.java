/*    */ package cn.ubot.service.customer.impl;
/*    */ 
/*    */ import cn.ubot.commin.AjaxResult;
/*    */ import cn.ubot.commin.EUComboBoxResult;
/*    */ import cn.ubot.commin.EUDataGridResult;
/*    */ import cn.ubot.commin.ExceptionUtil;
/*    */ import cn.ubot.mapper.generator.CustomerInfoMapper;
/*    */ import cn.ubot.pojo.generator.CustomerInfo;
/*    */ import cn.ubot.pojo.generator.CustomerInfoExample;
/*    */ import cn.ubot.service.customer.CustomerInfoService;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.github.pagehelper.PageInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class CustomerInfoServiceImpl
/*    */   implements CustomerInfoService
/*    */ {
/*    */   @Autowired
/*    */   private CustomerInfoMapper customerInfoMapper;
/*    */   
/*    */   public EUDataGridResult listCustomerInfo(Integer page, Integer rows) {
/* 28 */     EUDataGridResult result = new EUDataGridResult();
/* 29 */     PageHelper.startPage(page.intValue(), rows.intValue());
/* 30 */     CustomerInfoExample example = new CustomerInfoExample();
/* 31 */     List<CustomerInfo> customerInfoList = this.customerInfoMapper.selectByExample(example);
/* 32 */     result.setRows(customerInfoList);
/*    */     
/* 34 */     PageInfo<CustomerInfo> pageInfo = new PageInfo<CustomerInfo>(customerInfoList);
/* 35 */     result.setTotal(pageInfo.getTotal());
/* 36 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public AjaxResult addCustomerInfo(CustomerInfo customerInfo) {
/*    */     try {
/* 42 */       this.customerInfoMapper.insert(customerInfo);
/* 43 */     } catch (Exception e) {
/* 44 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*    */     } 
/* 46 */     return AjaxResult.ok();
/*    */   }
/*    */ 
/*    */   
/*    */   public AjaxResult updateCustomerInfo(CustomerInfo customerInfo) {
/*    */     try {
/* 52 */       this.customerInfoMapper.updateByPrimaryKey(customerInfo);
/* 53 */     } catch (Exception e) {
/* 54 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*    */     } 
/* 56 */     return AjaxResult.ok();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<EUComboBoxResult> getCustomerName() {
/* 61 */     List<EUComboBoxResult> l = new ArrayList<EUComboBoxResult>();
/*    */ 
/*    */     
/* 64 */     CustomerInfoExample example = new CustomerInfoExample();
/* 65 */     List<CustomerInfo> customerInfoList = this.customerInfoMapper.selectByExample(example);
/* 66 */     for (CustomerInfo customerInfo : customerInfoList) {
/* 67 */       EUComboBoxResult eur2 = new EUComboBoxResult(customerInfo.getCustomerName(), customerInfo.getCustomerId() + "(" + customerInfo.getCustomerName() + ")", null);
/* 68 */       l.add(eur2);
/*    */     } 
/* 70 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\customer\impl\CustomerInfoServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */