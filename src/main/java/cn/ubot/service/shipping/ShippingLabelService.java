package cn.ubot.service.shipping;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.ShippingLabel1;
import cn.ubot.pojo.generator.ShippingLabel2;
import java.util.List;

public interface ShippingLabelService {
	AjaxResult newShippingLabel(ShippingLabel1 paramShippingLabel1, List<ShippingLabel2> paramList, String paramString, Integer paramInteger);
  
	EUDataGridResult listShippingLabel(Integer paramInteger1, Integer paramInteger2, String paramString);
  
	EUDataGridResult listShippingLabel2(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
	AjaxResult addShippingLabel(List<ShippingLabel2> paramList, Integer paramInteger1, Integer paramInteger2, String paramString);
  
	AjaxResult deleteShippingLabe2(List<ShippingLabel2> paramList);
  
	AjaxResult updateShippingLabe1(ShippingLabel1 paramShippingLabel1);
}
