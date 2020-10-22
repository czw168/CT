package cn.ubot.service.customer;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.CustomerInfo;
import java.util.List;

public interface CustomerInfoService {
	EUDataGridResult listCustomerInfo(Integer paramInteger1, Integer paramInteger2);

	AjaxResult addCustomerInfo(CustomerInfo paramCustomerInfo);

	AjaxResult updateCustomerInfo(CustomerInfo paramCustomerInfo);

	List<EUComboBoxResult> getCustomerName();
}
