package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.ShippingLabel1;
import cn.ubot.pojo.generator.ShippingLabel1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingLabel1Mapper {
    long countByExample(ShippingLabel1Example example);

    int deleteByExample(ShippingLabel1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShippingLabel1 record);

    int insertSelective(ShippingLabel1 record);

    List<ShippingLabel1> selectByExample(ShippingLabel1Example example);

    ShippingLabel1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShippingLabel1 record, @Param("example") ShippingLabel1Example example);

    int updateByExample(@Param("record") ShippingLabel1 record, @Param("example") ShippingLabel1Example example);

    int updateByPrimaryKeySelective(ShippingLabel1 record);

    int updateByPrimaryKey(ShippingLabel1 record);
}