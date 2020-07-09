package cn.ubot.mapper.diy.production;

import cn.ubot.pojo.diy.production.Jo_;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoMapper_ {
  String getMaxJoNo();
  
  List<Jo_> listJo(@Param("joNo") String paramString);
  
  List<Jo_> listDetailsJo(@Param("joNo") String paramString);
  
  Integer getMaxItem(@Param("joNo") String paramString);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\mapper\diy\production\JoMapper_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */