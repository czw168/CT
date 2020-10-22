package cn.ubot.mapper.diy.production;

import cn.ubot.pojo.diy.production.Ltc_;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LtcMapper_ {
	List<Ltc_> listLtc(@Param("ltc") String paramString);
}
