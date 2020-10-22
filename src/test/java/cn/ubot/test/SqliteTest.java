package cn.ubot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.fabric.xmlrpc.base.Array;

import cn.ubot.config.DynamicDataSource;
import cn.ubot.mapper.SqliteMapper;
import cn.ubot.pojo.diy.ReportSetting;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SqliteTest {
	
	@Test
	public void b() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		SqliteMapper sqliteMapper = (SqliteMapper) applicationContext.getBean("sqliteMapper");
		
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		
		String productNumber = "022";
		String table = "tbl_inspect_detail_59";
		
		List<ReportSetting> reportSettings = sqliteMapper.getReportSettings(productNumber);
		
		System.out.println(reportSettings);
		
	}
	
	
	
	
	

}
