package cn.ubot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.ubot.pojo.diy.ColumnDetail;
import cn.ubot.pojo.diy.ParamDetail;
import cn.ubot.pojo.diy.ReportSetting;
import cn.ubot.pojo.diy.SqliteResult;
import cn.ubot.pojo.diy.SqliteResult2;
import cn.ubot.pojo.diy.SqliteResult4;

public interface SqliteMapper {
	
	// 根据日期去重获取所有LotNo
	List<String> getLotNo(@Param("date")String date,@Param("table")String table);
	// 获取该lotNo在表中出现的第一条数据的ID
	Integer getLotNoFirstID(@Param("lotNo")String lotNo,@Param("table")String table);
	// 获取该lotNo在表中出现的最后一条数据的ID
	Integer getLotNoLastID(@Param("lotNo")String lotNo,@Param("table")String table);
	// 获取该ID范围之间的OK数
	Integer getOkCount(@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID,@Param("table")String table);
	// 获取该ID范围之间状态为NG的数据的ID
	List<Integer> getID(@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID,@Param("table")String table);
	// 根据id和区域范围计算值
	Integer getSum(@Param("id")Integer id, @Param("l")Integer l,@Param("table")String table);
	// 获取实际OK数的平均值、最大值、最小值
	SqliteResult getOkResult(@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID, @Param("ids")List<Integer> ids, @Param("l")Integer l,@Param("table")String table);
	// 获取实际NG数的平均值、最大值、最小值
	SqliteResult getNgResult(@Param("actualNgIds")List<Integer> actualNgIds, @Param("l")Integer l,@Param("table")String table);
	// 获取该ID范围之间的AO,BO,W
	List<SqliteResult2> getLineChartData(@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID, @Param("l")Integer l,@Param("table")String table);

	// 根据实际NG ID和区域获取各组的NG数
	SqliteResult4 getGroupNgCount(@Param("actualNgIds")List<Integer> actualNgIds, @Param("l")Integer l,@Param("table")String table);
	
	// 根据实际NG ID和区域获取图片信息
	List<Map<String,Object>> getCatANgInfo(@Param("table")String table,@Param("actualNgIds")List<Integer> actualNgIds,@Param("l")Integer l);
	List<Map<String,Object>> getCatBNgInfo(@Param("table")String table,@Param("actualNgIds")List<Integer> actualNgIds,@Param("l")Integer l);
	List<Map<String,Object>> getCatCNgInfo(@Param("table")String table,@Param("actualNgIds")List<Integer> actualNgIds,@Param("l")Integer l);

	
	// ============================== 动态查询 ==============================
	
	// 获取所有产品号
	List<String> getProductNo();
	
	// 获取所有信息
	List<ReportSetting> getReportSettings(@Param("productNumber")String productNumber);
	
	// 获取所有产品号所对应的表ID
	List<String> getInspectionID();
	
	// 查看哪条link的字段最多，就用哪条link的字段来搭建表单
	List<Map<String,Object>> getMaxLinkColumnCount(@Param("table")String table);
	
	// 获取报表参数设定
	ReportSetting getReportSetting(@Param("productNumber")String productNumber,@Param("tableName")String tableName);
	
	// 根据日期去重获取所有LotNo
	List<String> t_getLotNo(@Param("table")String table,@Param("lotNumberColumn")String lotNumberColumn,@Param("date")String date);
	
	// 获取lotNo在表中第一次出现的ID
	Integer t_getLotNoFirstID(@Param("table")String table,@Param("lotNumberColumn")String lotNumberColumn,@Param("lotNo")String lotNo);
	// 获取lotNo在表中最后一次出现的ID
	Integer t_getLotNoLastID(@Param("table")String table,@Param("lotNumberColumn")String lotNumberColumn,@Param("lotNo")String lotNo);
	// 获取OK数量
	Integer t_getOkCount(@Param("table")String table,@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID);
	// 获取NG的ID
	List<Integer> t_getID(@Param("table")String table,@Param("lotNoFirstID")Integer lotNoFirstID, @Param("lotNoLastID")Integer lotNoLastID);
	// 获取ColumnDetail表信息
	List<Map<String,Object>> getColumnDetail(@Param("table")String table, @Param("link")Integer link);
	// 获取相似度字段名
	String getSimilarityColumnName(@Param("table")String table, @Param("link")Integer link);
	// 根据id和区域范围计算值
	Integer t_getSum(@Param("sql")String sql);
	
	Map<String,Object> t_getGroupNgCount(@Param("sql")String sql, @Param("actualNgIds")List<Integer> actualNgIds);
	
	// 获取图片信息
	List<Map<String,Object>> t_getCatANgInfo(@Param("sql")String sql, @Param("actualNgIds")List<Integer> actualNgIds, @Param("sql2")String sql2);
	List<Map<String,Object>> t_getCatBOrCatCNgInfo(@Param("sql")String sql, @Param("actualNgIds")List<Integer> actualNgIds, @Param("sql2")String sql2);
	
	int addReportSetting(ReportSetting reportSetting);
	
	int addParamDetail(ParamDetail paramDetail);
	
	int addColumnDetail(@Param("columnDetail")List<ColumnDetail> columnDetail);
	
	int delterParamDetailAndColumnDetailByRsId(int id);
	
	int deleteReportSetting(int id);

}
