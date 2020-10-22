package cn.ubot.service.production;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.ReelLabel;

public interface ReelLabelService {
	EUDataGridResult listReelLabel(Integer paramInteger1, Integer paramInteger2, String paramString);

	AjaxResult newReelLabel(ReelLabel paramReelLabel);

	AjaxResult updateReelLabel(ReelLabel paramReelLabel, Integer paramInteger);
}
