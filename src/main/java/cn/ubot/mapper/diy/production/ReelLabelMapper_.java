package cn.ubot.mapper.diy.production;

import cn.ubot.pojo.diy.production.ReelLabel_;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReelLabelMapper_ {
  List<ReelLabel_> getReelLabelList(@Param("ltc") String paramString);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\mapper\diy\production\ReelLabelMapper_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */