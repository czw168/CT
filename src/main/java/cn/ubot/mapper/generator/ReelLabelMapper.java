package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.ReelLabel;
import cn.ubot.pojo.generator.ReelLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReelLabelMapper {
    long countByExample(ReelLabelExample example);

    int deleteByExample(ReelLabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReelLabel record);

    int insertSelective(ReelLabel record);

    List<ReelLabel> selectByExample(ReelLabelExample example);

    ReelLabel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReelLabel record, @Param("example") ReelLabelExample example);

    int updateByExample(@Param("record") ReelLabel record, @Param("example") ReelLabelExample example);

    int updateByPrimaryKeySelective(ReelLabel record);

    int updateByPrimaryKey(ReelLabel record);
}