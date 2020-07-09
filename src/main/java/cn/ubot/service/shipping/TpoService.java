package cn.ubot.service.shipping;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridFootResult;
import cn.ubot.commin.EUDataGridResult;
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


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\shipping\TpoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */