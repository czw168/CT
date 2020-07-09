/*    */ package cn.ubot.service.customer.impl;
/*    */ 
/*    */ import cn.ubot.commin.AjaxResult;
/*    */ import cn.ubot.commin.EUDataGridResult;
/*    */ import cn.ubot.commin.ExceptionUtil;
/*    */ import cn.ubot.mapper.diy.customer.CustomerMapper_;
/*    */ import cn.ubot.mapper.generator.CustomerPnMapper;
/*    */ import cn.ubot.pojo.diy.customer.CustomerProduct;
/*    */ import cn.ubot.pojo.generator.CustomerPn;
/*    */ import cn.ubot.pojo.generator.CustomerPnExample;
/*    */ import cn.ubot.service.customer.CustomerPNService;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.github.pagehelper.PageInfo;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class CustomerPNServiceImpl
/*    */   implements CustomerPNService
/*    */ {
/*    */   @Autowired
/*    */   private CustomerMapper_ customerMapper_;
/*    */   @Autowired
/*    */   private CustomerPnMapper customerPnMapper;
/*    */   
/*    */   public EUDataGridResult listCustomerPn(Integer page, Integer rows) {
/* 32 */     EUDataGridResult result = new EUDataGridResult();
/* 33 */     PageHelper.startPage(page.intValue(), rows.intValue());
/*    */ 
/*    */     
/* 36 */     List<CustomerProduct> customerList = this.customerMapper_.listCustomer();
/* 37 */     result.setRows(customerList);
/*    */     
/* 39 */     PageInfo<CustomerProduct> pageInfo = new PageInfo<CustomerProduct>(customerList);
/* 40 */     result.setTotal(pageInfo.getTotal());
/* 41 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public AjaxResult addCustomerPn(CustomerPn customerPn) {
/*    */     try {
/* 47 */       this.customerPnMapper.insert(customerPn);
/* 48 */     } catch (Exception e) {
/* 49 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*    */     } 
/* 51 */     return AjaxResult.ok();
/*    */   }
/*    */ 
/*    */   
/*    */   public AjaxResult updateCustomerPn(CustomerPn customerPn) {
/*    */     try {
/* 57 */       this.customerPnMapper.updateByPrimaryKeyWithBLOBs(customerPn);
/* 58 */     } catch (Exception e) {
/* 59 */       e.printStackTrace();
/* 60 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*    */     } 
/* 62 */     return AjaxResult.ok();
/*    */   }
/*    */ 
/*    */   
/*    */   public AjaxResult getCustomerInfo(CustomerPn customerPn) {
/* 67 */     CustomerPnExample example = new CustomerPnExample();
/* 68 */     CustomerPnExample.Criteria criteria = example.createCriteria();
/* 69 */     criteria.andPnEqualTo(customerPn.getPn());
/* 70 */     criteria.andCustomerNameEqualTo(customerPn.getCustomerName());
/* 71 */     List<CustomerPn> CustomerPnList = this.customerPnMapper.selectByExampleWithBLOBs(example);
/* 72 */     if (CustomerPnList.isEmpty()) {
/* 73 */       return AjaxResult.ok();
/*    */     }
/* 75 */     return AjaxResult.ok(CustomerPnList.get(0));
/*    */   }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\customer\impl\CustomerPNServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */