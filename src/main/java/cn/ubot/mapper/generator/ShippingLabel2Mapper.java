package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.ShippingLabel2;
import cn.ubot.pojo.generator.ShippingLabel2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingLabel2Mapper {
    long countByExample(ShippingLabel2Example example);

    int deleteByExample(ShippingLabel2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShippingLabel2 record);

    int insertSelective(ShippingLabel2 record);

    List<ShippingLabel2> selectByExampleWithBLOBs(ShippingLabel2Example example);

    List<ShippingLabel2> selectByExample(ShippingLabel2Example example);

    ShippingLabel2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShippingLabel2 record, @Param("example") ShippingLabel2Example example);

    int updateByExampleWithBLOBs(@Param("record") ShippingLabel2 record, @Param("example") ShippingLabel2Example example);

    int updateByExample(@Param("record") ShippingLabel2 record, @Param("example") ShippingLabel2Example example);

    int updateByPrimaryKeySelective(ShippingLabel2 record);

    int updateByPrimaryKeyWithBLOBs(ShippingLabel2 record);

    int updateByPrimaryKey(ShippingLabel2 record);
}