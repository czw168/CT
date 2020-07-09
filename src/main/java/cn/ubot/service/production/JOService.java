package cn.ubot.service.production;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridFootResult;
import cn.ubot.commin.EUDataGridResult;
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


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\JOService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */