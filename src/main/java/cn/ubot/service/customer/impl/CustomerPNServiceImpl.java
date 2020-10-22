package cn.ubot.service.customer.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.customer.CustomerMapper_;
import cn.ubot.mapper.generator.CustomerPnMapper;
import cn.ubot.pojo.diy.customer.CustomerProduct;
import cn.ubot.pojo.generator.CustomerPn;
import cn.ubot.pojo.generator.CustomerPnExample;
import cn.ubot.service.customer.CustomerPNService;
import cn.ubot.utils.ExceptionUtils;

@Service
public class CustomerPNServiceImpl implements CustomerPNService {
	@Autowired
	private CustomerMapper_ customerMapper_;
	@Autowired
	private CustomerPnMapper customerPnMapper;

	public EUDataGridResult listCustomerPn(Integer page, Integer rows) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<CustomerProduct> customerList = this.customerMapper_.listCustomer();
		result.setRows(customerList);
		PageInfo<CustomerProduct> pageInfo = new PageInfo<CustomerProduct>(customerList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addCustomerPn(CustomerPn customerPn) {
		try {
			this.customerPnMapper.insert(customerPn);
		} catch (Exception e) {
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateCustomerPn(CustomerPn customerPn) {
		try {
			this.customerPnMapper.updateByPrimaryKeyWithBLOBs(customerPn);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult getCustomerInfo(CustomerPn customerPn) {
		CustomerPnExample example = new CustomerPnExample();
		CustomerPnExample.Criteria criteria = example.createCriteria();
		criteria.andPnEqualTo(customerPn.getPn());
		criteria.andCustomerNameEqualTo(customerPn.getCustomerName());
		List<CustomerPn> CustomerPnList = this.customerPnMapper.selectByExampleWithBLOBs(example);
		if (CustomerPnList.isEmpty()) {
			return AjaxResult.ok();
		}
		return AjaxResult.ok(CustomerPnList.get(0));
	}
}
