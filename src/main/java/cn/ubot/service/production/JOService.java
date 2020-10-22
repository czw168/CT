package cn.ubot.service.production;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridFootResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.Jo;
import java.util.List;

public interface JOService {
	EUDataGridResult listJO(Integer paramInteger1, Integer paramInteger2, String paramString);

	AjaxResult getMaxJoNo();

	AjaxResult newJO(List<Jo> paramList);

	EUDataGridFootResult listDetailsJO(Integer paramInteger1, Integer paramInteger2, String paramString);

	AjaxResult addJO(Jo paramJo);

	AjaxResult updateJO(Jo paramJo);
}
