package cn.ubot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ubot.pojo.diy.SqliteResult;

public interface SqliteMapper {
	
	// 去重获取所有LotNo
	List<String> getLotNo();
	// 获取该lotNo在表中出现的第一条数据的ID
	Integer getLotNoFirstID(String lotNo);
	// 获取该lotNo在表中出现的最后一条数据的ID
	Integer getLotNoLastID(String lotNo);
	// 获取该ID范围之间的OK数
	Integer getOkCount(@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID);
	// 获取该ID范围之间状态为NG的数据的ID
	List<Integer> getID(@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID);
	// 根据id和区域范围计算值
	Integer getSum(@Param("id")Integer id, @Param("l")Integer l);
	// 获取实际OK数的平均值、最大值、最小值
	SqliteResult getOkResult(@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID, @Param("ids")List<Integer> ids, @Param("l")Integer l);
	// 获取实际NG数的平均值、最大值、最小值
	SqliteResult getNgResult(@Param("ids")List<Integer> ids, @Param("l")Integer l);
}
