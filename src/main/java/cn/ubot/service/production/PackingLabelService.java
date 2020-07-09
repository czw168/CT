package cn.ubot.service.production;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridResult;
import cn.ubot.pojo.generator.PackingLabel;

public interface PackingLabelService {
  AjaxResult getMaxCarton();
  
  AjaxResult newPackingLabel(PackingLabel paramPackingLabel);
  
  EUDataGridResult getPackingLabelList(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2);
  
  AjaxResult updatePackingLabel(PackingLabel paramPackingLabel);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\PackingLabelService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */