package cn.ubot.mapper.diy.production;

import cn.ubot.pojo.diy.production.ReelLabel_;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReelLabelMapper_ {
	List<ReelLabel_> getReelLabelList(@Param("ltc") String paramString);
}
