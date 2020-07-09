package cn.ubot.service.product;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUComboBoxResult;
import cn.ubot.commin.EUDataGridComboBoxResult;
import cn.ubot.commin.EUDataGridResult;
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


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\product\ProductService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */