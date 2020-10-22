package cn.ubot.mapper.diy.shipping;

import cn.ubot.pojo.diy.shipping.ShippingLabel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingLabelMapper_ {
	String getMaxSerialNumber(@Param("param") String paramString);

	Integer getMaxId();

	List<ShippingLabel> getShippingLabelList(@Param("shipLot") String paramString);
}
