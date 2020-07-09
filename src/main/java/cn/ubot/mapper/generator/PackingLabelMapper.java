package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.PackingLabel;
import cn.ubot.pojo.generator.PackingLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PackingLabelMapper {
    long countByExample(PackingLabelExample example);

    int deleteByExample(PackingLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PackingLabel record);

    int insertSelective(PackingLabel record);

    List<PackingLabel> selectByExample(PackingLabelExample example);

    PackingLabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PackingLabel record, @Param("example") PackingLabelExample example);

    int updateByExample(@Param("record") PackingLabel record, @Param("example") PackingLabelExample example);

    int updateByPrimaryKeySelective(PackingLabel record);

    int updateByPrimaryKey(PackingLabel record);
}