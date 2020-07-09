package cn.ubot.mapper.diy.shipping;

import cn.ubot.pojo.diy.shipping.ShippingLabel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingLabelMapper_ {
  String getMaxSerialNumber(@Param("param") String paramString);
  
  Integer getMaxId();
  
  List<ShippingLabel> getShippingLabelList(@Param("shipLot") String paramString);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\mapper\diy\shipping\ShippingLabelMapper_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */