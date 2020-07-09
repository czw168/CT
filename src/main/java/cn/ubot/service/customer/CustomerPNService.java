package cn.ubot.service.customer;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridResult;
import cn.ubot.pojo.generator.CustomerPn;

public interface CustomerPNService {
  EUDataGridResult listCustomerPn(Integer paramInteger1, Integer paramInteger2);
  
  AjaxResult addCustomerPn(CustomerPn paramCustomerPn);
  
  AjaxResult updateCustomerPn(CustomerPn paramCustomerPn);
  
  AjaxResult getCustomerInfo(CustomerPn paramCustomerPn);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\customer\CustomerPNService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */