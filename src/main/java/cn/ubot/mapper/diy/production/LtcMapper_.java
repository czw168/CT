package cn.ubot.mapper.diy.production;

import cn.ubot.pojo.diy.production.Ltc_;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LtcMapper_ {
  List<Ltc_> listLtc(@Param("ltc") String paramString);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\mapper\diy\production\LtcMapper_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */