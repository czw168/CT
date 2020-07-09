package cn.ubot.service.production;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridResult;
import cn.ubot.pojo.generator.Ltc;

public interface LTCService {
  EUDataGridResult listLTC(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  AjaxResult newLTC(Ltc paramLtc);
  
  AjaxResult updateLTC(Ltc paramLtc);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\LTCService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */