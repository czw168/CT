package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.Ltc;
import cn.ubot.pojo.generator.LtcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LtcMapper {
    long countByExample(LtcExample example);

    int deleteByExample(LtcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ltc record);

    int insertSelective(Ltc record);

    List<Ltc> selectByExampleWithBLOBs(LtcExample example);

    List<Ltc> selectByExample(LtcExample example);

    Ltc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ltc record, @Param("example") LtcExample example);

    int updateByExampleWithBLOBs(@Param("record") Ltc record, @Param("example") LtcExample example);

    int updateByExample(@Param("record") Ltc record, @Param("example") LtcExample example);

    int updateByPrimaryKeySelective(Ltc record);

    int updateByPrimaryKeyWithBLOBs(Ltc record);

    int updateByPrimaryKey(Ltc record);
}