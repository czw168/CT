package cn.ubot.service.production;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.Ltc;

public interface LTCService {
	EUDataGridResult listLTC(Integer paramInteger1, Integer paramInteger2, String paramString);

	AjaxResult newLTC(Ltc paramLtc);

	AjaxResult updateLTC(Ltc paramLtc);
}
