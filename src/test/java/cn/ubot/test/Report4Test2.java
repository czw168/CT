//package cn.ubot.test;
//
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
//import com.github.pagehelper.PageInfo;
//
//import cn.ubot.config.DynamicDataSource;
//import cn.ubot.mapper.SqliteMapper;
//import cn.ubot.pojo.diy.ParamInfo;
//import cn.ubot.pojo.diy.SqliteResult4;
//import lombok.extern.slf4j.Slf4j;
//@Slf4j
//public class Report4Test2 {
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
//		//List<String> lotNos = sqliteMapper.getLotNo("2020-06-30");
//		List<String> lotNos = sqliteMapper.getLotNo(date,table);
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
//		log.debug("截取后格式的集合:" + lotNoList);
//		
//		
//		// 返回的数据集合
//		List<SqliteResult4> sqliteResult4List = new ArrayList<SqliteResult4>();
//        
//		for (int i = 0; i < 1; i++) {
//			String lotNo = "A120200915-309";
//			// 获取该lotNo在表中出现的第一条和最后一条的数据的ID
//			Integer lotNoFirstID = sqliteMapper.getLotNoFirstID(lotNo,table);
//			log.debug("lotNoFirstID:" + lotNoFirstID);
//			Integer lotNoLastID = sqliteMapper.getLotNoLastID(lotNo,table);
//			log.debug("lotNoLastID:" + lotNoLastID);
//			// 获取该ID范围之间的OK数
//			Integer okCount = sqliteMapper.getOkCount(lotNoFirstID, lotNoLastID,table);
//			// 获取该ID范围之间状态为NG的数据的ID
//			List<Integer> ids = sqliteMapper.getID(lotNoFirstID, lotNoLastID,table);
//
//			// 获取区域范围：lotNo中"-"之后的第一个数字
//			int l = Integer.parseInt(lotNo.substring(lotNo.indexOf("-") + 1, lotNo.indexOf("-") + 2));
//
//			// 实际NG数数量
//			int actualNgCount = 0;
//			// 实际NG数的ID集合
//			List<Integer> actualNgIds = new ArrayList<Integer>();
//
//			// 根据id和区域范围计算值
//			for (Integer id : ids) {
//				// 根据id和区域范围计算值
//				Integer sum = sqliteMapper.getSum(id, l,table);
//				if (null != sum && sum >= 1) {
//					actualNgCount++;
//					actualNgIds.add(id);
//				}
//			}
//			
//			log.debug("actualNgIds:" + actualNgIds);
//
//			// 不属于他区间的NG值都归于OK(例：xxx-201,总NG为100，L2NG有30，则其他(L1+L3)=70都为OK)
//			int otherOK = ids.size() - actualNgCount;
//						
//			// 实际OK数 = OK数 + 其他OK数
//			int actualOkCount = okCount + otherOK;
//
//			log.debug("Lot:" + lotNo);
//			log.debug("区域范围：" + l);
//			log.debug("OK总数：" + okCount);
//			log.debug("NG总数：" + ids.size());
//			log.debug("实际NG数：" + actualNgCount);
//			log.debug("实际OK数：" + actualOkCount);
//			
//			
//			SqliteResult4 sqliteResult4 = new SqliteResult4();
//			
//			if(!CollectionUtils.isEmpty(actualNgIds)) {
//				// 根据实际NG ID和区域获取各组的NG数
//				sqliteResult4 = sqliteMapper.getGroupNgCount(actualNgIds, l, table);
//				String result = sqliteResult4.getA() > 0 ? "Failed" : "OK";
//				sqliteResult4.setResult(result);
//			}else {
//				// 没有NG ID即代表OK
//				sqliteResult4.setResult("OK");
//			}
//			
//			sqliteResult4.setLotNo(lotNo);
//			sqliteResult4.setActualOkCount(actualOkCount);
//			sqliteResult4.setActualNgCount(actualNgCount);
//			
//			System.out.println(sqliteResult4.toString());
//			
//			// 存入集合
//			sqliteResult4List.add(sqliteResult4);
//			
//		}
//				
//				
//		
//	}
//
//}
