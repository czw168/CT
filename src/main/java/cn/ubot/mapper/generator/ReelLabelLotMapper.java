package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.ReelLabelLot;
import cn.ubot.pojo.generator.ReelLabelLotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReelLabelLotMapper {
    long countByExample(ReelLabelLotExample example);

    int deleteByExample(ReelLabelLotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReelLabelLot record);

    int insertSelective(ReelLabelLot record);

    List<ReelLabelLot> selectByExample(ReelLabelLotExample example);

    ReelLabelLot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReelLabelLot record, @Param("example") ReelLabelLotExample example);

    int updateByExample(@Param("record") ReelLabelLot record, @Param("example") ReelLabelLotExample example);

    int updateByPrimaryKeySelective(ReelLabelLot record);

    int updateByPrimaryKey(ReelLabelLot record);
}