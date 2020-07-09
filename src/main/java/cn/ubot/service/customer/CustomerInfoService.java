package cn.ubot.service.customer;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUComboBoxResult;
import cn.ubot.commin.EUDataGridResult;
import cn.ubot.pojo.generator.CustomerInfo;
import java.util.List;

public interface CustomerInfoService {
  EUDataGridResult listCustomerInfo(Integer paramInteger1, Integer paramInteger2);
  
  AjaxResult addCustomerInfo(CustomerInfo paramCustomerInfo);
  
  AjaxResult updateCustomerInfo(CustomerInfo paramCustomerInfo);
  
  List<EUComboBoxResult> getCustomerName();
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\customer\CustomerInfoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */