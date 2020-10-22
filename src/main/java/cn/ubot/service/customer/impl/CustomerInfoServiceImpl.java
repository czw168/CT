package cn.ubot.service.customer.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.generator.CustomerInfoMapper;
import cn.ubot.pojo.generator.CustomerInfo;
import cn.ubot.pojo.generator.CustomerInfoExample;
import cn.ubot.service.customer.CustomerInfoService;
import cn.ubot.utils.ExceptionUtils;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	@Autowired
	private CustomerInfoMapper customerInfoMapper;

	public EUDataGridResult listCustomerInfo(Integer page, Integer rows) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		CustomerInfoExample example = new CustomerInfoExample();
		List<CustomerInfo> customerInfoList = this.customerInfoMapper.selectByExample(example);
		result.setRows(customerInfoList);
		PageInfo<CustomerInfo> pageInfo = new PageInfo<CustomerInfo>(customerInfoList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addCustomerInfo(CustomerInfo customerInfo) {
		try {
			this.customerInfoMapper.insert(customerInfo);
		} catch (Exception e) {
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateCustomerInfo(CustomerInfo customerInfo) {
		try {
			this.customerInfoMapper.updateByPrimaryKey(customerInfo);
		} catch (Exception e) {
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public List<EUComboBoxResult> getCustomerName() {
		List<EUComboBoxResult> l = new ArrayList<EUComboBoxResult>();
		CustomerInfoExample example = new CustomerInfoExample();
		List<CustomerInfo> customerInfoList = this.customerInfoMapper.selectByExample(example);
		for (CustomerInfo customerInfo : customerInfoList) {
			EUComboBoxResult eur2 = new EUComboBoxResult(customerInfo.getCustomerName(),
					customerInfo.getCustomerId() + "(" + customerInfo.getCustomerName() + ")", null);
			l.add(eur2);
		}
		return l;
	}
}
