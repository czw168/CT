package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.Tpo1;
import cn.ubot.pojo.generator.Tpo1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Tpo1Mapper {
    long countByExample(Tpo1Example example);

    int deleteByExample(Tpo1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tpo1 record);

    int insertSelective(Tpo1 record);

    List<Tpo1> selectByExampleWithBLOBs(Tpo1Example example);

    List<Tpo1> selectByExample(Tpo1Example example);

    Tpo1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tpo1 record, @Param("example") Tpo1Example example);

    int updateByExampleWithBLOBs(@Param("record") Tpo1 record, @Param("example") Tpo1Example example);

    int updateByExample(@Param("record") Tpo1 record, @Param("example") Tpo1Example example);

    int updateByPrimaryKeySelective(Tpo1 record);

    int updateByPrimaryKeyWithBLOBs(Tpo1 record);

    int updateByPrimaryKey(Tpo1 record);
}