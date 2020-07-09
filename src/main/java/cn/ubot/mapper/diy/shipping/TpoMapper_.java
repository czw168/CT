package cn.ubot.mapper.diy.shipping;

import cn.ubot.pojo.diy.shipping.Tpo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpoMapper_ {
  String getMaxTpo();
  
  Integer getMaxId();
  
  List<Tpo> getTpoList(@Param("tpo") String paramString);
  
  Integer getMaxItem(@Param("tid") Integer paramInteger);
  
  Integer getTpoTotalById(@Param("id") Integer paramInteger);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\mapper\diy\shipping\TpoMapper_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */