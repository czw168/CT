package cn.ubot.service.customer;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.CustomerPn;

public interface CustomerPNService {
	EUDataGridResult listCustomerPn(Integer paramInteger1, Integer paramInteger2);

	AjaxResult addCustomerPn(CustomerPn paramCustomerPn);

	AjaxResult updateCustomerPn(CustomerPn paramCustomerPn);

	AjaxResult getCustomerInfo(CustomerPn paramCustomerPn);
}
