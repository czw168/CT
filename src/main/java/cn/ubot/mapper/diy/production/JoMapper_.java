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
