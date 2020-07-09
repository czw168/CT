package cn.ubot.mapper.diy.production;

import cn.ubot.pojo.diy.production.PackingLtc;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackingLabelMapper_ {
  String getMaxCarton();
  
  List<PackingLtc> getPackingLtc(@Param("carton") String paramString1, @Param("lotNo") String paramString2);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\mapper\diy\production\PackingLabelMapper_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */