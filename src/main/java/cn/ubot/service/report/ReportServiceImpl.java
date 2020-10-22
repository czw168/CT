package cn.ubot.service.report;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.SqliteMapper;
import cn.ubot.pojo.diy.ColumnDetail;
import cn.ubot.pojo.diy.ParamDetail;
import cn.ubot.pojo.diy.ReportSetting;
import cn.ubot.pojo.diy.SqliteResult;
import cn.ubot.pojo.diy.SqliteResult2;
import cn.ubot.pojo.diy.SqliteResult3;
import cn.ubot.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

	private static Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired
	private SqliteMapper sqliteMapper;
	//@Autowired
	//private JedisClient jedisClient;
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	//static final String BASE_URL = "C:\\Users\\victor_chen\\Desktop\\SQlite\\Image";
	//static final String BASE_URL = "X:\\022\\Image";
	static final String WINDOW_BASE_URL = "X:";
	static final String LINUX_BASE_URL = "/mnt/8TB/DATA/KEYENCE/CA-H1DB/192.168.0.10/VisionDB/CV-X470A_00_01_FC_27_03_6F/SD1/";
	
	//static final String BASE_URL = "\\c1129\\KEYENCE\\CA-H1DB\\192.168.0.10\\VisionDB\\CV-X470A_00_01_FC_27_03_6F\\SD1\\022\\Image";
	
	String firstFolderName = null;
	
	@Override
	public EUDataGridResult getReport1(Integer page, Integer rows, String date) {
		EUDataGridResult result = new EUDataGridResult();
		
		String d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").format(new Date(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = getSqliteResult(page, rows, d);

		if(null == map) {
			return null;
		}		
		
		List<String> lotNoList = (List<String>) map.get("lotNoList");
		List<SqliteResult> results = (List<SqliteResult>) map.get("results");
		
		result.setRows(results);
		//PageInfo<SqliteResult> pageInfo = new PageInfo<SqliteResult>(results);
		result.setTotal(lotNoList.size());
		return result;
	}
	
	public Map<String, Object> getSqliteResult(Integer page, Integer rows, String date) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		// 根据日期去重获取所有lotNo
		List<String> lotNos = sqliteMapper.getLotNo(date,null);
		// 存放截取后格式的lotNo
		List<String> lotNoList = new ArrayList<String>();
		
		if(lotNos.size() == 0) {
			return null;
		}
		
		for (String lotNo : lotNos) {
			// 查看lotNo中有几个"-"
			String lotNo2 = lotNo.replace("-", "");
			int count = lotNo.length() - lotNo2.length();
			if (count == 2) {
				// 截取第二个"-"之前的字符
				String lotNo3 = lotNo.substring(0, lotNo.lastIndexOf("-"));
				// 添加到集合
				if (!lotNoList.contains(lotNo3)) {
					// 将未包含的元素添加进listTemp集合中
					lotNoList.add(lotNo3);
				}
				
			}
		}
		logger.debug("截取后格式的集合:" + lotNoList);
		
		//	分页
//		ListPageUtil<String> listPageUtil = new ListPageUtil<String>(lotNoList, page, rows);
//        List<String> pagedList = listPageUtil.getPagedList();
//        logger.debug("分页后的集合:" + pagedList);
        
        // 存放最终查询结果的集合
     	List<SqliteResult> results = new ArrayList<SqliteResult>();
		for (int i = 0; i < lotNoList.size(); i++) {
			String lotNo = lotNoList.get(i);
			// 获取该lotNo在表中出现的第一条和最后一条的数据的ID
			Integer lotNoFirstID = sqliteMapper.getLotNoFirstID(lotNo,null);
			Integer lotNoLastID = sqliteMapper.getLotNoLastID(lotNo,null);
			// 获取该ID范围之间的OK数
			Integer okCount = sqliteMapper.getOkCount(lotNoFirstID, lotNoLastID,null);
			// 获取该ID范围之间状态为NG的数据的ID
			List<Integer> ids = sqliteMapper.getID(lotNoFirstID, lotNoLastID,null);

			// 获取区域范围：lotNo中"-"之后的第一个数字
			int l = Integer.parseInt(lotNo.substring(lotNo.indexOf("-") + 1, lotNo.indexOf("-") + 2));

			// 实际NG数数量
			int actualNgCount = 0;
			// 实际NG数的ID集合
			List<Integer> actualNgIds = new ArrayList<Integer>();

			// 根据id和区域范围计算值
			for (Integer id : ids) {
				// 根据id和区域范围计算值
				Integer sum = sqliteMapper.getSum(id, l,null);
				if (sum >= 1) {
					actualNgCount++;
					actualNgIds.add(id);
				}
			}

			// 不属于他区间的NG值都归于OK(例：xxx-201,总NG为100，L2NG有30，则其他(L1+L3)=70都为OK)
			int otherOK = ids.size() - actualNgCount;
						
			// 实际OK数 = OK数 + 其他OK数
			int actualOkCount = okCount + otherOK;

			logger.debug("Lot:" + lotNo);
			logger.debug("OK总数:" + okCount);
			logger.debug("NG总数:" + ids.size());
			logger.debug("实际NG数:" + actualNgCount);
			logger.debug("实际OK数:" + actualOkCount);

			// 获取实际OK数的平均值、最大值、最小值
			SqliteResult okResult = sqliteMapper.getOkResult(lotNoFirstID, lotNoLastID, ids, l,null);

			if (null != okResult) {
				logger.debug("OK:");
				logger.debug("avg:" + okResult.getOkAvg());
				logger.debug("max:" + okResult.getOkMax());
				logger.debug("min:" + okResult.getOkMin());
			}

			// 获取实际NG数的平均值、最大值、最小值
			SqliteResult ngResult = new SqliteResult();
			if(actualNgCount != 0) {
				ngResult = sqliteMapper.getNgResult(actualNgIds, l,null);
			}else {
				ngResult.setNgAvg(0d);
				ngResult.setNgMax(0d);
				ngResult.setNgMin(0d);
			}
			

			if (null != ngResult) {
				logger.debug("NG:");
				logger.debug("avg:" + ngResult.getNgAvg());
				logger.debug("max:" + ngResult.getNgMax());
				logger.debug("min:" + ngResult.getNgMin());
			}

			SqliteResult result = new SqliteResult(lotNo, actualOkCount, okResult.getOkAvg(), okResult.getOkMax(),
					okResult.getOkMin(), actualNgCount, ngResult.getNgAvg(), ngResult.getNgMax(), ngResult.getNgMin());

			results.add(result);

		}
		
		map.put("lotNoList", lotNoList);
		map.put("results", results);

		return map;

	}

	@Override
	public AjaxResult getLineChartData(String lotNo) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		//lotNo = "A120200629-102";
		
		// 根据LotNo获取第一条数据ID和最后一条数据ID
		Integer lotNoFirstID = sqliteMapper.getLotNoFirstID(lotNo,null);
		// 没记录代表lotNo不存在
		if(null == lotNoFirstID) {
			return AjaxResult.build(400, "The LotNo doesn't exist !");
		}
		
		logger.debug("lotNoFirstID:" + lotNoFirstID);	// 4434
		
		Integer lotNoLastID = sqliteMapper.getLotNoLastID(lotNo,null);
		logger.debug("lotNoLastID:" + lotNoLastID);		// 13062
		
		// 截取lotNo倒数第三个数
		Integer l = Integer.parseInt(lotNo.substring(lotNo.length()-3, lotNo.length()-2));
		
		// 获取该ID之间的所有数据
		List<SqliteResult2> lineChartData = sqliteMapper.getLineChartData(lotNoFirstID, lotNoLastID, l,null);
		
		List<Double> aos = new ArrayList<Double>();
		List<Double> bos = new ArrayList<Double>();
		List<Double> ws = new ArrayList<Double>();
		
		for(SqliteResult2 data : lineChartData) {
			
			aos.add(data.getAo());
			bos.add(data.getBo());
			ws.add(data.getW());
			
			logger.debug("==========================================");
			logger.debug("AO:" + data.getAo());
			logger.debug("BO:" + data.getBo());
			logger.debug("W:" + data.getW());
		}
		
		map.put("aos", aos);
		map.put("bos", bos);
		map.put("ws", ws);
		
		return AjaxResult.ok(map);
		
	}
	
	
	
	@Override
	public EUDataGridResult getReport3(String lotNo, String table) {
		
		EUDataGridResult euDataGridResult = new EUDataGridResult();
		
		ReportSetting paramInfo = sqliteMapper.getReportSetting(null, table);
		// 产品号
		String productNumber = paramInfo.getProductNumber();
		// 总链数
		int linkCount = paramInfo.getLinkCount();
		// lotNo的字段名
		String lotNumberColumn = paramInfo.getLotNumberColumnName();
		
		// 查看redis中是否有数据
//		String jsonData = (String) redisTemplate.boundValueOps(lotNo + "_" + table).get();
//		if(null != jsonData) {
//			return euDataGridResult = JsonUtils.jsonToPojo(jsonData, EUDataGridResult.class);
//		}
		
		// 获取该lotNo在表中出现的第一条和最后一条的数据的ID
		Integer lotNoFirstID = sqliteMapper.t_getLotNoFirstID(table, lotNumberColumn, lotNo);
		logger.debug("lotNoFirstID:" + lotNoFirstID);
		
		if(null == lotNoFirstID) {
			// 这个表中没有这个lotNo
			return null;
		}
		
		Integer lotNoLastID = sqliteMapper.t_getLotNoLastID(table, lotNumberColumn, lotNo);
		logger.debug("lotNoLastID:" + lotNoLastID);
		
		// 获取该ID范围之间状态为NG的数据的ID
		List<Integer> ids = sqliteMapper.t_getID(table, lotNoFirstID, lotNoLastID);

		int link = 0;
		// 如果只有一条链则默认为1
		if(linkCount == 1) {
			link = linkCount;
		}else {
			// 获取链号：lotNo中"-"之后的第一个数字
			link = Integer.parseInt(lotNo.substring(lotNo.indexOf("-") + 1, lotNo.indexOf("-") + 2));
		}

		// 实际NG数的ID集合
		List<Integer> actualNgIds = new ArrayList<Integer>();
		
		// 拼接查询SQL
		List<Map<String, Object>> columnDetailList = sqliteMapper.getColumnDetail(table, link);
		
		// 获取相似度字段名
		String similarityColumnName = sqliteMapper.getSimilarityColumnName(table, link);
		
		// 获取B组的字段数
		int bCount = 0;
		for (int i = 0; i < columnDetailList.size(); i++) {
			Map<String, Object> map = columnDetailList.get(i);
			String group = (String)map.get("group");
			if(group.equals("B")) {
				bCount++;
			}
		}
		
		/**
		 * sql：getSum 的 sql语句
		 * sql2_1: A组前段部分sql语句
		 * sql2_2: A组后段部分sql语句
		 * sql3_1: B组前段部分sql语句
		 * sql3_2: B组后段部分sql语句
		 * sql4_1: C组前段部分sql语句
		 * sql4_2: C组后段部分sql语句
		 */
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2_1 = new StringBuffer();
		StringBuffer sql2_2 = new StringBuffer();
		StringBuffer sql3_1 = new StringBuffer();
		StringBuffer sql3_2 = new StringBuffer();
		StringBuffer sql4_1 = new StringBuffer();
		StringBuffer sql4_2 = new StringBuffer();
		sql.append("select sum(");
		sql2_1.append("select Date,ProcCount,");
		sql3_1.append("select Date,ProcCount from (select Date,ProcCount,");
		sql3_2.append(") AS temp where ");
		sql4_1.append("select Date,ProcCount from (select Date,ProcCount,");
		sql4_2.append(") AS temp where ");
		
		for (int i = 0; i < columnDetailList.size(); i++) {
			Map<String, Object> map = columnDetailList.get(i);
			String columnName = (String)map.get("column_name");
			String alias = (String)map.get("alias");
			String group = (String)map.get("group");
			if(group.equals("A")) {
				sql.append("if(" + columnName + " > " + similarityColumnName + ",0,1)");
				sql2_1.append(columnName + " as " + alias + " from " + table + " where ID IN ");
				sql2_2.append("and if(" + columnName + " > " + similarityColumnName + ",0,1) = 1");
			}else if(group.equals("B")){
				sql.append(columnName);
				sql3_1.append(columnName + " as " + alias);
				sql3_2.append(alias + " = 1");
				if(i != bCount) {
					sql3_1.append(" , ");
					sql3_2.append(" or ");
				}
			}else if(group.equals("C")){
				sql.append(columnName);
				sql4_1.append(columnName + " as " + alias);
				sql4_2.append(alias + " = 1");
				if(i != columnDetailList.size() - 1) {
					sql4_1.append(" , ");
					sql4_2.append(" or ");
				}
			}
			if(i != columnDetailList.size() - 1) {
				sql.append(" + ");
			}
		}
		sql.append(") as `sum` from " + table + " where ID = ");
		sql3_1.append(" from " + table + " A where A.ID IN ");
		sql4_1.append(" from " + table + " A where A.ID IN ");
		
		// 根据id和链号计算值
		for (Integer id : ids) {
			Integer sum = sqliteMapper.t_getSum(sql.toString() + id);
			if (null != sum && sum >= 1) {
				actualNgIds.add(id);
			}
		}
		
		logger.debug("actualNgIds:" + actualNgIds);
		
		if(CollectionUtils.isEmpty(actualNgIds)) {
			return null;
		}
		
		// 获取A组的NG信息
		List<Map<String, Object>> catANgInfo = sqliteMapper.t_getCatANgInfo(sql2_1.toString(), actualNgIds, sql2_2.toString());
		// 获取A组的NG信息
		List<Map<String, Object>> catBNgInfo = sqliteMapper.t_getCatBOrCatCNgInfo(sql3_1.toString(), actualNgIds, sql3_2.toString());
		// 获取A组的NG信息
		List<Map<String, Object>> catCNgInfo = sqliteMapper.t_getCatBOrCatCNgInfo(sql4_1.toString(), actualNgIds, sql4_2.toString());
		
		List<String> pictureAUrls = getPictureUrls(catANgInfo,productNumber);
		List<String> pictureBUrls = getPictureUrls(catBNgInfo,productNumber);
		List<String> pictureCUrls = getPictureUrls(catCNgInfo,productNumber);
		
		SqliteResult3 sqliteResult3 = new SqliteResult3();
		sqliteResult3.setACount(pictureAUrls.size());
		sqliteResult3.setBCount(pictureBUrls.size());
		sqliteResult3.setCCount(pictureCUrls.size());
		sqliteResult3.setPictureAUrls(pictureAUrls);
		sqliteResult3.setPictureBUrls(pictureBUrls);
		sqliteResult3.setPictureCUrls(pictureCUrls);
		
		List<SqliteResult3> list = new ArrayList<SqliteResult3>();
		list.add(sqliteResult3);
		
		euDataGridResult.setRows(list);
		euDataGridResult.setTotal(list.size());
		
		// 存入redis
		//redisTemplate.boundValueOps(lotNo + "_" + table).set(JsonUtils.objectToJson(euDataGridResult));
		
		return euDataGridResult;
	}

	@Override
	public EUDataGridResult getReport4(String date, String table) {
		
		EUDataGridResult euDataGridResult = new EUDataGridResult();
		date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(date));
		
		// 查看redis中是否有数据
		String jsonData = (String) redisTemplate.boundValueOps(date + "_" + table).get();
		if(null != jsonData) {
			return euDataGridResult = JsonUtils.jsonToPojo(jsonData, EUDataGridResult.class);
		}
		
		// 根据日期去重获取所有lotNo
		List<String> lotNos = sqliteMapper.getLotNo(date, table);
		
		if(CollectionUtils.isEmpty(lotNos)) {
			return null;
		}
		
		// 存放截取后格式的lotNo
		List<String> lotNoList = new ArrayList<String>();
		
		for (String lotNo : lotNos) {
			if(lotNo == null) {
				continue;
			}
			// 查看lotNo中有几个"-"
			String lotNo2 = lotNo.replace("-", "");
			int count = lotNo.length() - lotNo2.length();
			if (count == 2) {
				// 截取第二个"-"之前的字符
				String lotNo3 = lotNo.substring(0, lotNo.lastIndexOf("-"));
				// 添加到集合
				if (!lotNoList.contains(lotNo3)) {
					// 将未包含的元素添加进listTemp集合中
					lotNoList.add(lotNo3);
				}
				
			}
		}
		System.out.println("截取后的LotNo：" + lotNoList);
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		ReportSetting paramInfo = sqliteMapper.getReportSetting(null, table);
		// 总链数
		int linkCount = paramInfo.getLinkCount();
		// lotNo的字段名
		String lotNumberColumn = paramInfo.getLotNumberColumnName();
		
		for (int j = 0; j < lotNoList.size(); j++) {
			String lotNo = lotNoList.get(j);
			// 获取该lotNo在表中出现的第一条和最后一条的数据的ID
			Integer lotNoFirstID = sqliteMapper.t_getLotNoFirstID(table, lotNumberColumn, lotNo);
			log.debug("lotNoFirstID:" + lotNoFirstID);
			Integer lotNoLastID = sqliteMapper.t_getLotNoLastID(table, lotNumberColumn, lotNo);
			log.debug("lotNoLastID:" + lotNoLastID);
			// 获取该ID范围之间的OK数
			Integer okCount = sqliteMapper.t_getOkCount(table, lotNoFirstID, lotNoLastID);
			// 获取该ID范围之间状态为NG的数据的ID
			List<Integer> ids = sqliteMapper.t_getID(table, lotNoFirstID, lotNoLastID);
			
			int link = 0;
			// 如果只有一条链则默认为1
			if(linkCount == 1) {
				link = linkCount;
			}else {
				// 获取链号：lotNo中"-"之后的第一个数字
				link = Integer.parseInt(lotNo.substring(lotNo.indexOf("-") + 1, lotNo.indexOf("-") + 2));
			}
			
			// 实际NG数数量
			int actualNgCount = 0;
			// 实际NG数的ID集合
			List<Integer> actualNgIds = new ArrayList<Integer>();
			
			// 拼接查询SQL
			List<Map<String, Object>> columnDetailList = sqliteMapper.getColumnDetail(table, link);
			
			// 获取相似度字段名
			String similarityColumnName = sqliteMapper.getSimilarityColumnName(table, link);
			
			/**
			 * sql：getSum 的 sql语句
			 * sql2：getGroupNgCount 的 sql语句
			 */
			StringBuffer sql = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();
			sql.append("select sum(");
			sql2.append("select ");
			for (int i = 0; i < columnDetailList.size(); i++) {
				Map<String, Object> map = columnDetailList.get(i);
				String columnName = (String)map.get("column_name");
				String alias = (String)map.get("alias");
				String group = (String)map.get("group");
				if(group.equals("A")) {
					sql.append("if(" + columnName + " > " + similarityColumnName + ",0,1)");
					sql2.append("sum(if(" + columnName + " > " + similarityColumnName + ",0,1)) as " + alias);
				}else {
					sql.append(columnName);
					sql2.append("sum(" + columnName + ") as " + alias);
				}
				if(i != columnDetailList.size() - 1) {
					sql.append(" + ");
					sql2.append(" , ");
				}
			}
			sql.append(") as `sum` from " + table + " where ID = ");
			sql2.append(" from " + table + " where ID IN");
			
			System.out.println(sql);
			System.out.println(sql2);
			
			// 根据id和链号计算值
			for (Integer id : ids) {
				Integer sum = sqliteMapper.t_getSum(sql.toString() + id);
				if (null != sum && sum >= 1) {
					actualNgCount++;
					actualNgIds.add(id);
				}
			}
			
			log.debug("actualNgIds:" + actualNgIds);
			
			// 不属于他区间的NG值都归于OK(例：xxx-201,总NG为100，L2NG有30，则其他(L1+L3)=70都为OK)
			int otherOK = ids.size() - actualNgCount;
						
			// 实际OK数 = OK数 + 其他OK数
			int actualOkCount = okCount + otherOK;

			log.debug("Lot:" + lotNo);
			log.debug("区域范围：" + link);
			log.debug("OK总数：" + okCount);
			log.debug("NG总数：" + ids.size());
			log.debug("实际NG数：" + actualNgCount);
			log.debug("实际OK数：" + actualOkCount);
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			if(!CollectionUtils.isEmpty(actualNgIds)) {
				// 根据实际NG ID和区域获取各组的NG数
				map = sqliteMapper.t_getGroupNgCount(sql2.toString(), actualNgIds);
				System.out.println(map);
				BigDecimal a = (BigDecimal)map.get("a");
				String value = a.intValue() > 0 ? "Failed" : "OK";
				map.put("result", value);
			}else {
				// 没有NG的ID即代表OK
				map.put("result", "OK");
			}
			
			map.put("lotNo", lotNo);
			map.put("actualOkCount", actualOkCount);
			map.put("actualNgCount", actualNgCount);
			// 存入集合
			list.add(map);
		}
		
		euDataGridResult.setRows(list);
		//PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
		euDataGridResult.setTotal(lotNoList.size());
		
		// 存入redis
		//jedisClient.set(date + "_" + table, JsonUtils.objectToJson(euDataGridResult));
		redisTemplate.boundValueOps(date + "_" + table).set(JsonUtils.objectToJson(euDataGridResult));
	
		return euDataGridResult;
	}
	
	// ===========================================  report3 封装的方法 START ===========================================
	
	/**
	 * 	获取图片地址
	 * @param ngInfo：catA、catB、catC的ngInfo
	 *  @param productNumber：产品号
	 */
	public List<String> getPictureUrls(List<Map<String, Object>> ngInfo,String productNumber) {

		// 存放图片url集合
		List<String> pictureUrls = new ArrayList<String>();
		
		for (int i = 0; i < ngInfo.size(); i++) {
			
			Map<String, Object> map = ngInfo.get(i);
			String date = (String) map.get("Date");
			String procCount = String.format("%010d", (int) map.get("ProcCount"));
			
			log.info("=======================================================================================");
			log.info("Date:" + date);
			log.info("procCount:" + procCount);
			
			// 格式转换,例:2020-09-09 11:35:46 转换成 20200909_113546
			String folderName = date.replace(" ", "_").replace("-", "").replace(":", "");
			log.info("folderName:" + folderName);
			firstFolderName = folderName;
			
			List<String> folders = null;
			if(System.getProperties().getProperty("os.name").contains("Windows")) {
				folders = getFolders(WINDOW_BASE_URL + "\\" + productNumber + "\\Image", folderName);
			}else {
				folders = getFolders(LINUX_BASE_URL + "/" + productNumber + "/Image", folderName);
			}
			
			// 本业务逻辑只会返回一个目录名
			String actualFolderName = folders.get(0);
			log.info("actualFolderName:" + actualFolderName);
			// 结果：X:\000\Image\20200903_125916\20200903_164438_0000108693_&Cam2Img
			// 实际：X:\000\Image\20200903_164222\20200903_164438_0000108693_&Cam2Img
			//					 20200903_164438
			
			// 图片名(不含后缀)
			String pictureName = folderName + "_" + procCount + "_&Cam2Img";
			// 获取图片全名(含后缀)
			List<String> pictureNames = null;
			if(System.getProperties().getProperty("os.name").contains("Windows")) {
				pictureNames = getPictures(WINDOW_BASE_URL + "\\" + productNumber + "\\Image\\" + actualFolderName, pictureName);
			}else {
				pictureNames = getPictures(LINUX_BASE_URL + "/" + productNumber + "/Image/" + actualFolderName, pictureName);
			}
			
			// 本业务逻辑只会返回一张图片
			String actualPictureName = pictureNames.get(0);
			log.info("actualPictureName:" + actualPictureName);
			
			// C:\Users\victor_chen\Desktop\SQlite\Image\20200909_114506\20200909_114831_0000013000_&Cam2Img.Bmp
			
			// 拼接url
			String pictureUrl = null;
			if(System.getProperties().getProperty("os.name").contains("Windows")) {
				pictureUrl = WINDOW_BASE_URL + "\\" + productNumber + "\\Image\\" + actualFolderName + "\\" + actualPictureName;
			}else {
				pictureUrl = LINUX_BASE_URL + "/" + productNumber + "/Image/" + actualFolderName + "/" + actualPictureName;
			}
			pictureUrls.add(pictureUrl);
			
		} 
		
		for (String url : pictureUrls) {
			System.out.println(url);
		}
		
		return pictureUrls;
	}

	/**
	 * 	查看文件目录是否存在（精准查询）
	 */
	public boolean getFolder(String folderUrl) {
		File file = new File(folderUrl);
		if (file.exists()) {
			return true;
		} 
		return false;
	}
	
	/**
	 * 	获取真实的目录名（模糊查询）
	 */
	public List<String> getFolders(String url, String folderName){
		
		String queryFolderName = folderName.substring(0, folderName.length() - 2);
		
		List<String> folderNames = new ArrayList<String>();
		
		File file = new File(url);
		File fa[] = file.listFiles();
		queryFolderName = queryFolderName == null ? "" : queryFolderName;
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.getName().indexOf(queryFolderName) != -1) {
				if (fs.isDirectory()) {
					folderNames.add(fs.getName());
				}
			}
		}
		
		// 如果没有这个目录则换一个目录继续找
		if(CollectionUtils.isEmpty(folderNames)) {
			folderName = newFolderName(folderName);
			folderNames = getFolders(url,folderName);
		}else {
			// 本业务只会出现一张图片
			String result = folderNames.get(0);
			String resultSuffix = result.substring(result.indexOf("_") + 1);
			String firstFolderNameNameSuffix = firstFolderName.substring(firstFolderName.indexOf("_") + 1);
			// 如果找到的目录名的后缀数字大于查找目录名的后缀数字,说明图片不是在这个目录,需要换一个目录继续找
			if(Long.parseLong(resultSuffix) > Long.parseLong(firstFolderNameNameSuffix)) {
				folderName = newFolderName(folderName);
				folderNames = getFolders(url,folderName);
			}
		}
		log.debug("folderNames：" + folderNames);
		return folderNames;
		
	}
	
	/**
	 * 	获取图片名（包含后缀名）
	 */
	public List<String> getPictures(String url, String pictureName) {
		
		List<String> pictureNames = new ArrayList<String>();
		
		File file = new File(url);
		File fa[] = file.listFiles();
		pictureName = pictureName == null ? "" : pictureName;
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.getName().indexOf(pictureName) != -1) {
				if (!fs.isDirectory()) {
					pictureNames.add(fs.getName());
				}
			}
		}
		
		return pictureNames;
		
	}
	
	/**
	 * 	获取新的目录名（分钟数-1)
	 * 
	 * 	例1：
	 * 	folderName：	20200909_110352
	 * 	prefix:		20200909_
	 * 	content:	1103
	 * 	suffix:		52
	 * 	hh:			11
	 * 	mm:			03 （这里减1）
	 * 
	 *  newFolderName:	20200909_110252
	 *
	 * 	例2：
	 * 	folderName：	20200909_110052
	 * 	prefix:		20200909_
	 * 	content:	1100
	 * 	suffix:		52
	 * 	hh:			11
	 * 	mm:			00 （这里减1）
	 * 
	 *  newFolderName:	20200909_105952
	 
	 * @param folderName
	 * @return
	 */
	public String newFolderName(String folderName) {
		// 前缀
		String prefix = folderName.substring(0, folderName.indexOf("_") + 1);
		log.info("prefix:" + prefix);
		// 主体内容
		String content = folderName.substring(folderName.indexOf("_") + 1, folderName.indexOf("_") + 5);
		log.info("content:" + content);
		// 后缀
		String suffix = folderName.substring(folderName.length() - 2);
		log.info("suffix:" + suffix);
		
		// 主体内容转换成【时：分】格式
		String hh = content.substring(0, 2);
		String mm = content.substring(2);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
		//1644   0443
		try {
			Date time1 = sdf.parse(hh + ":" + mm);
			Date time2 = sdf.parse("00:01");
			long l = time1.getTime() - time2.getTime() + sdf2.parse("1970").getTime();
			String result = sdf.format(new Date(l));
			// 再转回文件名返回
			result = result.replace(":", "");
			folderName = prefix + result + suffix;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		log.info("newFolderName:" + folderName);

		return folderName;
	}
	
	// ===========================================  report3 封装的方法 END ===========================================

	@Override
	public List<EUComboBoxResult> getProductNo() {
		List<EUComboBoxResult> results = new ArrayList<EUComboBoxResult>();
		List<String> productNos = sqliteMapper.getProductNo();
		for (String productNo : productNos) {
			EUComboBoxResult result = new EUComboBoxResult(productNo,productNo, null);
			results.add(result);
		}
		return results;
	}

	@Override
	public EUDataGridResult getReportSettings(String productNumber) {
		EUDataGridResult result = new EUDataGridResult();
		//PageHelper.startPage(page.intValue(), rows.intValue());
		List<ReportSetting> paramInfos = sqliteMapper.getReportSettings(productNumber);
		result.setRows(paramInfos);
		result.setTotal(paramInfos.size());
		return result;
	}
	
	@Override
	public List<EUComboBoxResult> getInspectionID() {
		List<EUComboBoxResult> results = new ArrayList<EUComboBoxResult>();
		List<String> inspectionID = sqliteMapper.getInspectionID();
		for (String id : inspectionID) {
			EUComboBoxResult result = new EUComboBoxResult("tbl_inspect_detail_" + id,"tbl_inspect_detail_" + id, null);
			results.add(result);
		}
		return results;
	}

	@Override
	public AjaxResult getDatagrid(String date, String table) {
		// 获取表名
		//ParamInfo paramInfo = sqliteMapper.getParamInfo(productNumber);
		//String table = paramInfo.getTableName();
		
		int maxLink = 0;
		int maxCount = 0;
		
		// 查看哪条link的字段最多，就用哪条link的字段来搭建表单,如果字段数一样，则使用link1
		List<Map<String,Object>> list = sqliteMapper.getMaxLinkColumnCount(table);
		for (Map<String, Object> map : list) {
			int link = (int)map.get("link");
			long count = (long)map.get("count");
			if(count > maxCount) {
				maxCount = (int)count;
				maxLink = link;
			}
		}
		
		// 存放A组字段的别名
		List<String> groupA = new ArrayList<String>();
		// 存放B组字段的别名
		List<String> groupB = new ArrayList<String>();
		// 存放C组字段的别名
		List<String> groupC = new ArrayList<String>();
		
		List<Map<String,Object>> columnDetailList = sqliteMapper.getColumnDetail(table, maxLink);
		
		for (int i = 0; i < columnDetailList.size(); i++) {
			Map<String, Object> map = columnDetailList.get(i);
			//String columnName = (String)map.get("column_name");
			String alias = (String)map.get("alias");
			String group = (String)map.get("group");
			if(group.equals("A")) {
				groupA.add(alias);
			}else if(group.equals("B")){
				groupB.add(alias);
			}else if(group.equals("C")){
				groupC.add(alias);
			}
		}
		
		// 拼接table
		StringBuilder str = new StringBuilder(1000);
		
		str.append(
				"<table id=\"dg\" class=\"easyui-datagrid\"" + 
						"data-options=\"" + 
							"fitColumns:true," +
							"loadMsg:'The amount of data is huge. Please wait a moment...'," +
							"method:'GET'," +
							"url:'../report/report4?date=" + date + "&table=" + table + 
						"'\">" +
				"<thead>" +
					"<tr>" + 
						"<th data-options=\"field:'lotNo',align:'center',width:'200'\" rowspan=\"3\">Lot No.</th>" +
						"<th data-options=\"field:'actualOkCount',align:'center',width:'100'\" rowspan=\"3\">OK</th>" +
						// A组长度 + B组长度 + C组长度 + 1(total列)
						"<th colspan=\"" + (groupA.size() + groupB.size() + groupC.size() + 1) + "\">NG</th>" +
						"<th data-options=\"field:'result',align:'center',styler:resultStyler,width:'200'\" rowspan=\"3\">Result</th>" +
					"</tr>" +
					"<tr>" +
						"<th>Cat.A</th>" +
						"<th colspan=\"" +groupB.size()  + "\">Cat.B</th>" +
						"<th colspan=\"" + groupC.size() + "\">Cat.C</th>" +
						"<th>Total</th>" +
					"</tr>" +
					"<tr>");
		
		// A组字段
		for (String column : groupA) {
			str.append("<th data-options=\"field:'" + column + "',align:'center',width:'50',formatter:function(val,rows){" +
							"if (val == undefined) {" +
								"return 0;" +
							"} else {" +
								"return val;" +
							"}}" +
						"\">" + column.toUpperCase() + "</th>");
		}
		// B组字段
		for (String column : groupB) {
			str.append("<th data-options=\"field:'" + column + "',align:'center',width:'50',formatter:function(val,rows){" + 
							"if (val == undefined) {" +
								"return 0;" +
							"} else {" +
								"return val;" +
							"}}" +
						"\">" + column.toUpperCase() + "</th>");
		}
		// C组字段
		for (String column : groupC) {
			str.append("<th data-options=\"field:'" + column + "',align:'center',width:'50',formatter:function(val,rows){" +
								"if (val == undefined) {" +
									"return 0;" +
								"} else {" +
									"return val;" +
								"}}" +
						"\">" + column.toUpperCase() + "</th>");
		}
		// total字段
		str.append("<th data-options=\"field:'actualNgCount',align:'center',width:'100'\"></th>");
		str.append("</tr>");
		str.append("</thead>");
		str.append("</table>");
		
		return AjaxResult.ok(str.toString());
	}

	@Override
	public AjaxResult getReportSetting(String productNumber,String tableName) {
		// 获取表名
		ReportSetting paramInfo = sqliteMapper.getReportSetting(productNumber,tableName);
		if(null == paramInfo) {
			return null;
		}
		return AjaxResult.ok(paramInfo.getTableName());
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addReportSetting(ReportSetting reportSetting) {
		sqliteMapper.addReportSetting(reportSetting);
		List<ParamDetail> paramDetail = reportSetting.getParamDetail();
		for (ParamDetail pd : paramDetail) {
			pd.setRsId(reportSetting.getId());
			sqliteMapper.addParamDetail(pd);
			List<ColumnDetail> columnDetail = pd.getColumnDetail();
			for (ColumnDetail cd : columnDetail) {
				cd.setPdId(pd.getId());
			}
			sqliteMapper.addColumnDetail(columnDetail);
		}
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateReportSetting(ReportSetting reportSetting) {
		int id = reportSetting.getId();
		// 根据id 删除 paramDetaial 和 columnDetail
		sqliteMapper.delterParamDetailAndColumnDetailByRsId(id);
		// 新增
		List<ParamDetail> paramDetail = reportSetting.getParamDetail();
		for (ParamDetail pd : paramDetail) {
			pd.setRsId(id);
			sqliteMapper.addParamDetail(pd);
			List<ColumnDetail> columnDetail = pd.getColumnDetail();
			for (ColumnDetail cd : columnDetail) {
				cd.setPdId(pd.getId());
			}
			sqliteMapper.addColumnDetail(columnDetail);
		}
		
		String tableName = reportSetting.getTableName();
		// 表参数结构改变了,需要删除redis缓存的数据
		//Set<Object> keys = redisTemplate.keys("*tbl_inspect_detail_59");
		Set<Object> keys = redisTemplate.keys("*" + tableName);
		redisTemplate.delete(keys);
		
	}

	@Override
	public void deleteReportSetting(int id,String tableName) {
		
		sqliteMapper.deleteReportSetting(id);
		
		// 表参数结构改变了,需要删除redis缓存的数据
		Set<Object> keys = redisTemplate.keys("*" + tableName);
		redisTemplate.delete(keys);
	}

}
