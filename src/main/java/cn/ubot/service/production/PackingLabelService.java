package cn.ubot.service.production;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.PackingLabel;

public interface PackingLabelService {
	AjaxResult getMaxCarton();

	AjaxResult newPackingLabel(PackingLabel paramPackingLabel);

	EUDataGridResult getPackingLabelList(Integer paramInteger1, Integer paramInteger2, String paramString1,
			String paramString2);

	AjaxResult updatePackingLabel(PackingLabel paramPackingLabel);
}
