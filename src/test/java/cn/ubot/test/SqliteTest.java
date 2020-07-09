package cn.ubot.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.util.StringUtils;
import com.mysql.fabric.xmlrpc.base.Array;

import cn.ubot.config.DynamicDataSource;
import cn.ubot.mapper.SqliteMapper;
import cn.ubot.pojo.Sqlite;
import cn.ubot.pojo.diy.SqliteResult;

public class SqliteTest {

	private static Logger logger = LoggerFactory.getLogger(SqliteTest.class);

	// @Autowired
	// private SqliteMapper sqliteMapper;

	@Test
	public void t1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml");

		SqliteMapper sqliteMapper = (SqliteMapper) applicationContext.getBean("sqliteMapper");

		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);

//		// 去重获取所有lotNo
//		List<String> lotNos = sqliteMapper.getLotNo();
//		// 存放截取后格式的lotNo
//		Set<String> lotNoSet = new HashSet<String>();
//		
//		for (String lotNo : lotNos) {
//			// 查看lotNo中有几个"-"
//			String lotNo2 = lotNo.replace("-", "");
//			int count = lotNo.length() - lotNo2.length();
//			if(count == 2) {
//				// 截取第二个"-"之前的字符
//				String lotNo3 = lotNo.substring(0, lotNo.lastIndexOf("-"));
//				// 添加到集合
//				lotNoSet.add(lotNo3);
//			}
//		}

//		Set<String> lotNoSet = new HashSet<String>();
//		lotNoSet.add("A120200629-102");
//		
//		
//		for (String lotNo : lotNoSet) {
//			// 根据LotNo获取所有数据状态为NG的ID
//			List<Integer> ids = sqliteMapper.getID(lotNo);
//			// 实际NG数
//			int actualNgCount = 0;
//			for(Integer id : ids) {
//				// 区域范围：截取lotNo中"-"之后的第一个数字
//				String l = lotNo.substring(lotNo.indexOf("-")+1,lotNo.indexOf("-")+2);
//				// 根据id和区域范围计算值
//				Integer sum = sqliteMapper.getSum(id, Integer.parseInt(l));
//				if(sum >= 1) {
//					actualNgCount ++;
//				}
//			}
//			
//			System.out.println("实际NG数：" + actualNgCount);
//			
//			// OK数
//			Integer okCount = sqliteMapper.getOkCount("A120200701-306");
//			System.out.println("OK数：" + okCount);
//			
//			// 实际OK数
//			Integer actualOkCount = okCount - actualNgCount;
//			System.out.println("实际OK数：" + actualOkCount);
//			
//			String s = lotNo + "-----OK ： " + actualOkCount + "-----NG ：" + actualNgCount;
//			System.out.println(s);
//			
//		}

	}

	@Test
	public void t3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml");
		SqliteMapper sqliteMapper = (SqliteMapper) applicationContext.getBean("sqliteMapper");

		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);

		List<SqliteResult> results = getSqliteResult(sqliteMapper);
		logger.info(" ============================== Start ==================================== ");
		for(SqliteResult result : results) {
			logger.info("lotNo:" + result.getLotNo()); 
			logger.info("ActualOkCount:" + result.getActualOkCount());
			logger.info("OkAvg:" + result.getOkAvg());
			logger.info("OkMax:" + result.getOkMax());
			logger.info("OkMin:" + result.getOkMin());
			logger.info("ActualNgCount:" + result.getActualNgCount());
			logger.info("NgAvg:" + result.getNgAvg());
			logger.info("NgMax:" + result.getNgMax());
			logger.info("NgMin:" + result.getNgMin());
			logger.info(" --------------------------------------------------------------------- ");
		}
		logger.info(" ============================== End ====================================== ");
	}

	public List<SqliteResult> getSqliteResult(SqliteMapper sqliteMapper) {

		// 返回的结果集合
		List<SqliteResult> results = new ArrayList<SqliteResult>();

//		// 去重获取所有lotNo
//		List<String> lotNos = sqliteMapper.getLotNo();
//		// 存放截取后格式的lotNo
//		Set<String> lotNoSet = new HashSet<String>();
//
//		for (String lotNo : lotNos) {
//			// 查看lotNo中有几个"-"
//			String lotNo2 = lotNo.replace("-", "");
//			int count = lotNo.length() - lotNo2.length();
//			if (count == 2) {
//				// 截取第二个"-"之前的字符
//				String lotNo3 = lotNo.substring(0, lotNo.lastIndexOf("-"));
//				// 添加到集合
//				lotNoSet.add(lotNo3);
//			}
//		}
		
		
		// 去重获取所有lotNo
		List<String> lotNos = sqliteMapper.getLotNo();
		// 存放截取后格式的lotNo
		List<String> lotNoSet = new ArrayList<String>();

		for (String lotNo : lotNos) {
			// 查看lotNo中有几个"-"
			String lotNo2 = lotNo.replace("-", "");
			int count = lotNo.length() - lotNo2.length();
			if (count == 2) {
				// 截取第二个"-"之前的字符
				String lotNo3 = lotNo.substring(0, lotNo.lastIndexOf("-"));
				// 添加到集合
				if (!lotNoSet.contains(lotNo3)) {
					// 将未包含的元素添加进listTemp集合中
					lotNoSet.add(lotNo3);
				}
				
			}
		}
		
		
		
		//List<String> lotNoSet = new ArrayList<String>();
		//lotNoSet.add("A120200629-102");

		int startPage = 0;
		int endPage = 5;
		
		
		//for (String lotNo : lotNoSet) {
		for (int i = startPage; i < endPage; i++) {
			String lotNo = lotNoSet.get(i);
			// 获取该lotNo在表中出现的第一条和最后一条的数据的ID
			Integer lotNoFirstID = sqliteMapper.getLotNoFirstID(lotNo);
			Integer lotNoLastID = sqliteMapper.getLotNoLastID(lotNo);
			// 获取该ID范围之间的OK数
			Integer okCount = sqliteMapper.getOkCount(lotNoFirstID, lotNoLastID);
			// 获取该ID范围之间状态为NG的数据的ID
			List<Integer> ids = sqliteMapper.getID(lotNoFirstID, lotNoLastID);

			// 获取区域范围：lotNo中"-"之后的第一个数字
			int l = Integer.parseInt(lotNo.substring(lotNo.indexOf("-") + 1, lotNo.indexOf("-") + 2));

			// 实际NG数
			int actualNgCount = 0;

			// 根据id和区域范围计算值
			for (Integer id : ids) {
				// 根据id和区域范围计算值
				Integer sum = sqliteMapper.getSum(id, l);
				if (sum >= 1) {
					actualNgCount++;
				}
			}

			// 实际OK数 = OK数 - 实际NG数
			int actualOkCount = okCount - actualNgCount;

			logger.debug("Lot:" + lotNo);
			logger.debug("OK数:" + okCount);
			logger.debug("实际NG数:" + actualNgCount);
			logger.debug("实际OK数:" + actualOkCount);

			// 获取实际OK数的平均值、最大值、最小值
			SqliteResult okResult = sqliteMapper.getOkResult(lotNoFirstID, lotNoLastID, ids, l);

			if (null != okResult) {
				logger.debug("OK:");
				logger.debug("avg:" + okResult.getOkAvg());
				logger.debug("max:" + okResult.getOkMax());
				logger.debug("min:" + okResult.getOkMin());
			}

			// 获取实际NG数的平均值、最大值、最小值
			SqliteResult ngResult = new SqliteResult();
			if(actualNgCount != 0) {
				ngResult = sqliteMapper.getNgResult(ids, l);
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

		return results;

	}

	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();
		// master 修改
		// dev 修改
		// dev 修改2
	}
	
	
}
