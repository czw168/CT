package cn.ubot.service.shipping;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridFootResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.Tpo1;
import cn.ubot.pojo.generator.Tpo2;
import java.util.List;

public interface TpoService {
	AjaxResult getMaxTpo();

	AjaxResult newTpo1(Tpo1 paramTpo1);

	AjaxResult updateTpo1(Tpo1 paramTpo1);

	AjaxResult updateTpo2(Tpo2 paramTpo2);

	EUDataGridResult listTpo(Integer paramInteger1, Integer paramInteger2, String paramString);

	EUDataGridFootResult listTpo2(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);

	EUDataGridResult listNotToChooseTpo2(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);

	AjaxResult addTpo(Tpo2 paramTpo2, String paramString);

	AjaxResult updateTpo(List<Tpo2> paramList, Tpo1 paramTpo11, Tpo1 paramTpo12);

	AjaxResult getIdByTpo(String paramString);
}
