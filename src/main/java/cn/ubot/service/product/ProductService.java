package cn.ubot.service.product;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.ProductInfo;
import java.util.List;

public interface ProductService {
	EUDataGridResult listProduct(Integer paramInteger1, Integer paramInteger2);

	AjaxResult addProduct(ProductInfo paramProductInfo);

	AjaxResult updateProduct(ProductInfo paramProductInfo);

	List<EUComboBoxResult> getProductPn();

	List<EUDataGridComboBoxResult> getProductPn_();

	AjaxResult getRequirementByPn(String paramString);

	AjaxResult getDwgNoByPn(String paramString);
}
