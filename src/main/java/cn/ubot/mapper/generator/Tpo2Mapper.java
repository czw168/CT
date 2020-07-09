package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.Tpo2;
import cn.ubot.pojo.generator.Tpo2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Tpo2Mapper {
    long countByExample(Tpo2Example example);

    int deleteByExample(Tpo2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tpo2 record);

    int insertSelective(Tpo2 record);

    List<Tpo2> selectByExample(Tpo2Example example);

    Tpo2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tpo2 record, @Param("example") Tpo2Example example);

    int updateByExample(@Param("record") Tpo2 record, @Param("example") Tpo2Example example);

    int updateByPrimaryKeySelective(Tpo2 record);

    int updateByPrimaryKey(Tpo2 record);
}