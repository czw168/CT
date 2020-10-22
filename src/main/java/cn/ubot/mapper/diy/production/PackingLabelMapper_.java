package cn.ubot.mapper.diy.production;

import cn.ubot.pojo.diy.production.PackingLtc;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackingLabelMapper_ {
	String getMaxCarton();

	List<PackingLtc> getPackingLtc(@Param("carton") String paramString1, @Param("lotNo") String paramString2);
}
