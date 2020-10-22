package cn.ubot.mapper.diy.product;

import org.apache.ibatis.annotations.Param;

public interface ProductInfoMapper_ {
	String getRequirementByPn(@Param("pn") String paramString);
}
