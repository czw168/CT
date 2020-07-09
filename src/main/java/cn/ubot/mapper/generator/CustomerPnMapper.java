package cn.ubot.mapper.generator;

import cn.ubot.pojo.generator.CustomerPn;
import cn.ubot.pojo.generator.CustomerPnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerPnMapper {
    long countByExample(CustomerPnExample example);

    int deleteByExample(CustomerPnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerPn record);

    int insertSelective(CustomerPn record);

    List<CustomerPn> selectByExampleWithBLOBs(CustomerPnExample example);

    List<CustomerPn> selectByExample(CustomerPnExample example);

    CustomerPn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustomerPn record, @Param("example") CustomerPnExample example);

    int updateByExampleWithBLOBs(@Param("record") CustomerPn record, @Param("example") CustomerPnExample example);

    int updateByExample(@Param("record") CustomerPn record, @Param("example") CustomerPnExample example);

    int updateByPrimaryKeySelective(CustomerPn record);

    int updateByPrimaryKeyWithBLOBs(CustomerPn record);

    int updateByPrimaryKey(CustomerPn record);
}