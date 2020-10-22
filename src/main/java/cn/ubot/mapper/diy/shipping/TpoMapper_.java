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
