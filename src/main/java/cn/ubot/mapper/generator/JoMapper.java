package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.Jo;
import cn.ubot.pojo.generator.JoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoMapper {
    long countByExample(JoExample example);

    int deleteByExample(JoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jo record);

    int insertSelective(Jo record);

    List<Jo> selectByExampleWithBLOBs(JoExample example);

    List<Jo> selectByExample(JoExample example);

    Jo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jo record, @Param("example") JoExample example);

    int updateByExampleWithBLOBs(@Param("record") Jo record, @Param("example") JoExample example);

    int updateByExample(@Param("record") Jo record, @Param("example") JoExample example);

    int updateByPrimaryKeySelective(Jo record);

    int updateByPrimaryKeyWithBLOBs(Jo record);

    int updateByPrimaryKey(Jo record);
}