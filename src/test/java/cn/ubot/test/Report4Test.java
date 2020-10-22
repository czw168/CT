//package cn.ubot.test;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.util.CollectionUtils;
//
//import cn.ubot.config.DynamicDataSource;
//import cn.ubot.mapper.SqliteMapper;
//import cn.ubot.pojo.diy.ParamInfo;
//import lombok.extern.slf4j.Slf4j;
//@Slf4j
//public class Report4Test {
//	
//	@Test
//	public void b() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
//		SqliteMapper sqliteMapper = (SqliteMapper) applicationContext.getBean("sqliteMapper");
//		
//		// 重点： 实际操作证明，切换的时候最好清空一下
//		DynamicDataSource.clearCustomerType();
//		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
//		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
//		
//		String date = "2020-09-15";
//		String productNumber = "022";
//		
//		
//		ParamInfo paramInfo = sqliteMapper.getParamInfo(productNumber);
//		String table = paramInfo.getTableName();
//		System.out.println(paramInfo);
//		
//		
//		// 根据日期去重获取所有lotNo
//		List<String> lotNos = sqliteMapper.getLotNo(date, table);
//		// 存放截取后格式的lotNo
//		List<String> lotNoList = new ArrayList<String>();
//		
//		if(lotNos.size() == 0) {
//			return;
//		}
//		
//		for (String lotNo : lotNos) {
//			if(lotNo == null) {
//				continue;
//			}
//			// 查看lotNo中有几个"-"
//			String lotNo2 = lotNo.replace("-", "");
//			int count = lotNo.length() - lotNo2.length();
//			if (count == 2) {
//				// 截取第二个"-"之前的字符
//				String lotNo3 = lotNo.substring(0, lotNo.lastIndexOf("-"));
//				// 添加到集合
//				if (!lotNoList.contains(lotNo3)) {
//					// 将未包含的元素添加进listTemp集合中
//					lotNoList.add(lotNo3);
//				}
//				
//			}
//		}
//		System.out.println("截取后的LotNo：" + lotNoList);
//		
//		//String lotNo = "A120200915-101";
//		String lotNo = "A120200915-309";
//		
//		List<Map<String,Object>> list = new ArrayList<>();
//		
//		// 总链数
//		int linkCount = paramInfo.getLinkCount();
//		// lotNo的字段名
//		String lotNumberCloumn = paramInfo.getLotNumberCloumn();
//		
//		// 获取该lotNo在表中出现的第一条和最后一条的数据的ID
//		Integer lotNoFirstID = sqliteMapper.t_getLotNoFirstID(table, lotNumberCloumn, lotNo);
//		log.debug("lotNoFirstID:" + lotNoFirstID);
//		Integer lotNoLastID = sqliteMapper.t_getLotNoLastID(table, lotNumberCloumn, lotNo);
//		log.debug("lotNoLastID:" + lotNoLastID);
//		// 获取该ID范围之间的OK数
//		Integer okCount = sqliteMapper.t_getOkCount(table, lotNoFirstID, lotNoLastID);
//		// 获取该ID范围之间状态为NG的数据的ID
//		List<Integer> ids = sqliteMapper.t_getID(table, lotNoFirstID, lotNoLastID);
//		
//		int l = 0;
//		// 如果只有一条链则默认为1
//		if(linkCount == 1) {
//			l = linkCount;
//		}else {
//			// 获取链号：lotNo中"-"之后的第一个数字
//			l = Integer.parseInt(lotNo.substring(lotNo.indexOf("-") + 1, lotNo.indexOf("-") + 2));
//		}
//		
//		// 实际NG数数量
//		int actualNgCount = 0;
//		// 实际NG数的ID集合
//		List<Integer> actualNgIds = new ArrayList<Integer>();
//		
//		// 拼接查询SQL
//		List<Map<String, Object>> paramDetailList = sqliteMapper.getParamDetail(table, l);
//		
//		// 获取相似度字段名
//		String similarityColumnName = sqliteMapper.getSimilarityColumnName(table, l);
//		
//		/**
//		 * sql：getSum 的 sql语句
//		 * sql2：getGroupNgCount 的 sql语句
//		 */
//		StringBuffer sql = new StringBuffer();
//		StringBuffer sql2 = new StringBuffer();
//		sql.append("select sum(");
//		sql2.append("select ");
//		for (int i = 0; i < paramDetailList.size(); i++) {
//			Map<String, Object> map = paramDetailList.get(i);
//			String columnName = (String)map.get("column_name");
//			String alias = (String)map.get("alias");
//			String group = (String)map.get("group");
//			if(group.equals("A")) {
//				sql.append("if(" + columnName + " > " + similarityColumnName + ",0,1)");
//				sql2.append("sum(if(" + columnName + " > " + similarityColumnName + ",0,1)) as " + alias);
//			}else {
//				sql.append(columnName);
//				sql2.append("sum(" + columnName + ") as " + alias);
//			}
//			if(i != paramDetailList.size() - 1) {
//				sql.append(" + ");
//				sql2.append(" , ");
//			}
//		}
//		sql.append(") as `sum` from " + table + " where ID = ");
//		sql2.append(" from " + table + " where ID IN");
//		
//		System.out.println(sql);
//		System.out.println(sql2);
//		
//
//		// 根据id和链号计算值
//		for (Integer id : ids) {
//			Integer sum = sqliteMapper.t_getSum(sql.toString() + id);
//			if (null != sum && sum >= 1) {
//				actualNgCount++;
//				actualNgIds.add(id);
//			}
//		}
//		
//		log.debug("actualNgIds:" + actualNgIds);
//		
//		// 不属于他区间的NG值都归于OK(例：xxx-201,总NG为100，L2NG有30，则其他(L1+L3)=70都为OK)
//		int otherOK = ids.size() - actualNgCount;
//					
//		// 实际OK数 = OK数 + 其他OK数
//		int actualOkCount = okCount + otherOK;
//
//		log.debug("Lot:" + lotNo);
//		log.debug("区域范围：" + l);
//		log.debug("OK总数：" + okCount);
//		log.debug("NG总数：" + ids.size());
//		log.debug("实际NG数：" + actualNgCount);
//		log.debug("实际OK数：" + actualOkCount);
//		
//		Map<String,Object> map = new HashMap<String, Object>();
//		
//		if(!CollectionUtils.isEmpty(actualNgIds)) {
//			// 根据实际NG ID和区域获取各组的NG数
//			map = sqliteMapper.t_getGroupNgCount(sql2.toString(), actualNgIds);
//			System.out.println(map);
//			BigDecimal a = (BigDecimal)map.get("a");
//			String value = a.intValue() > 0 ? "Failed" : "OK";
//			map.put("result", value);
//		}else {
//			// 没有NG的ID即代表OK
//			map.put("result", "OK");
//		}
//		
//		map.put("lotNo", lotNo);
//		map.put("actualOkCount", actualOkCount);
//		map.put("actualNgCount", actualNgCount);
//		// 存入集合
//		list.add(map);
//		
//	}
//
//}
