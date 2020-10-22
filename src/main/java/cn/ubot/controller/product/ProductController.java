package cn.ubot.controller.product;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.ProductInfo;
import cn.ubot.service.product.ProductService;
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
@RequestMapping({ "/product/" })
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping({ "/{page}" })
	public String showPage(@PathVariable String page) {
		return "/product/" + page;
	}

	@GetMapping({ "/listProduct" })
	@ResponseBody
	EUDataGridResult listProduct(Integer page, Integer rows) {
		return this.productService.listProduct(page, rows);
	}

	@PostMapping({ "/addProduct" })
	@ResponseBody
	AjaxResult addProduct(@RequestBody JSONObject obj) {
		ProductInfo productInfo = (ProductInfo) JsonUtils.jsonToPojo(obj.toJSONString(), ProductInfo.class);
		return this.productService.addProduct(productInfo);
	}

	@PostMapping({ "/updateProduct" })
	@ResponseBody
	AjaxResult updateProduct(@RequestBody JSONObject obj) {
		ProductInfo productInfo = (ProductInfo) JsonUtils.jsonToPojo(obj.toJSONString(), ProductInfo.class);
		return this.productService.updateProduct(productInfo);
	}

	@PostMapping({ "/getProductPn" })
	@ResponseBody
	List<EUComboBoxResult> getProductPn() {
		return this.productService.getProductPn();
	}

	@PostMapping({ "/getProductPn_" })
	@ResponseBody
	List<EUDataGridComboBoxResult> getProductPn_() {
		return this.productService.getProductPn_();
	}

	@GetMapping({ "/getRequirementByPn" })
	@ResponseBody
	AjaxResult getRequirementByPn(String pn) {
		return this.productService.getRequirementByPn(pn);
	}

	@PostMapping({ "/getDwgNoByPn" })
	@ResponseBody
	AjaxResult getDwgNoByPn(@RequestBody JSONObject obj) {
		String pn = obj.getString("pn");
		return this.productService.getDwgNoByPn(pn);
	}
}
