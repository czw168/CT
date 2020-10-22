package cn.ubot.controller.customer;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.CustomerInfo;
import cn.ubot.pojo.generator.CustomerPn;
import cn.ubot.service.customer.CustomerInfoService;
import cn.ubot.service.customer.CustomerPNService;
import cn.ubot.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/customer" })
public class CustomerController {
	@Autowired
	private CustomerInfoService customerInfoService;
	@Autowired
	private CustomerPNService customerPNService;

	@RequestMapping({ "/{page}" })
	public String showPage(@PathVariable String page) {
		return "/customer/" + page;
	}

	@GetMapping({ "/listCustomerInfo" })
	@ResponseBody
	EUDataGridResult listCustomerInfo(Integer page, Integer rows) {
		return this.customerInfoService.listCustomerInfo(page, rows);
	}

	@PostMapping({ "/addCustomerInfo" })
	@ResponseBody
	AjaxResult addCustomerInfo(@RequestBody JSONObject obj) {
		CustomerInfo customerInfo = (CustomerInfo) JsonUtils.jsonToPojo(obj.toJSONString(), CustomerInfo.class);
		return this.customerInfoService.addCustomerInfo(customerInfo);
	}

	@PostMapping({ "/updateCustomerInfo" })
	@ResponseBody
	AjaxResult updateCustomerInfo(@RequestBody JSONObject obj) {
		CustomerInfo customerInfo = (CustomerInfo) JsonUtils.jsonToPojo(obj.toJSONString(), CustomerInfo.class);
		return this.customerInfoService.updateCustomerInfo(customerInfo);
	}

	@PostMapping({ "/getCustomerName" })
	@ResponseBody
	List<EUComboBoxResult> getCustomerName() {
		return this.customerInfoService.getCustomerName();
	}

	@GetMapping({ "/listCustomerPn" })
	@ResponseBody
	EUDataGridResult listCustomerPn(Integer page, Integer rows) {
		return this.customerPNService.listCustomerPn(page, rows);
	}

	@PostMapping({ "/addCustomerPn" })
	@ResponseBody
	AjaxResult addCustomerPn(@RequestBody JSONObject obj) {
		CustomerPn customerPn = (CustomerPn) JsonUtils.jsonToPojo(obj.toJSONString(), CustomerPn.class);
		return this.customerPNService.addCustomerPn(customerPn);
	}

	@PostMapping({ "/updateCustomerPn" })
	@ResponseBody
	AjaxResult updateCustomerPn(@RequestBody JSONObject obj) {
		CustomerPn customerPn = (CustomerPn) JsonUtils.jsonToPojo(obj.toJSONString(), CustomerPn.class);
		return this.customerPNService.updateCustomerPn(customerPn);
	}

	@PostMapping({ "/getCustomerInfo" })
	@ResponseBody
	AjaxResult getCustomerInfo(@RequestBody JSONObject obj) {
		CustomerPn customerPn = (CustomerPn) JsonUtils.jsonToPojo(obj.toJSONString(), CustomerPn.class);
		return this.customerPNService.getCustomerInfo(customerPn);
	}
}
