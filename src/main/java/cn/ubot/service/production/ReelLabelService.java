package cn.ubot.service.production;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridResult;
import cn.ubot.pojo.generator.ReelLabel;

public interface ReelLabelService {
  EUDataGridResult listReelLabel(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  AjaxResult newReelLabel(ReelLabel paramReelLabel);
  
  AjaxResult updateReelLabel(ReelLabel paramReelLabel, Integer paramInteger);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\service\production\ReelLabelService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */