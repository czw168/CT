package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.ShippingLot;
import cn.ubot.pojo.generator.ShippingLotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingLotMapper {
    long countByExample(ShippingLotExample example);

    int deleteByExample(ShippingLotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShippingLot record);

    int insertSelective(ShippingLot record);

    List<ShippingLot> selectByExample(ShippingLotExample example);

    ShippingLot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShippingLot record, @Param("example") ShippingLotExample example);

    int updateByExample(@Param("record") ShippingLot record, @Param("example") ShippingLotExample example);

    int updateByPrimaryKeySelective(ShippingLot record);

    int updateByPrimaryKey(ShippingLot record);
}