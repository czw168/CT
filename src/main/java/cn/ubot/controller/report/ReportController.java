package cn.ubot.controller.report;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.config.DynamicDataSource;
import cn.ubot.pojo.diy.ReportSetting;
import cn.ubot.service.report.ReportService;
import cn.ubot.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/report")
@Slf4j
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping({"/{page}"})
	public String showPage(@PathVariable String page,String date,String table,String lotNo,Model model) { 
		model.addAttribute("date", date);
		model.addAttribute("table", table);
		model.addAttribute("lotNo", lotNo);
		return "/report/" + page; 
	}
	
	@RequestMapping(value = "/getReportSetting", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getReportSetting(String productNumber,String tableName) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getReportSetting(productNumber, tableName);
	}
	
	@RequestMapping(value = "/getDatagrid", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getTable(String date, String productNumber) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getDatagrid(date, productNumber);
	}
	
	@RequestMapping(value = "/report1", method = RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult getReport1(Integer page, Integer rows, String date) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getReport1(page,rows,date);
	}
	
	@RequestMapping(value = "/report2", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getReport2(String lotNo) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getLineChartData(lotNo);
	}
	
	
	@RequestMapping(value = "/getProductNo", method = RequestMethod.GET)
	@ResponseBody
	public List<EUComboBoxResult> getProductNo() {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getProductNo();
	}
	
	@RequestMapping(value = "/getReportSettings", method = RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult getReportSettings(String productNumber) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getReportSettings(productNumber);
	}
	
	@RequestMapping(value = "/getInspectionID", method = RequestMethod.GET)
	@ResponseBody
	public List<EUComboBoxResult> getInspectionID() {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getInspectionID();
	}
	
	@RequestMapping(value = "/report3", method = RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult getReport3(String lotNo,String table) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getReport3(lotNo, table);
	}
	
	
	@RequestMapping(value = "/report4", method = RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult getReport4(String date,String table) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		return reportService.getReport4(date,table);
	}
	
	@RequestMapping("/getImage")
	public void getImage(@RequestParam("url") String url, HttpServletRequest request, HttpServletResponse response){
		FileInputStream in;
		response.setContentType("application/octet-stream;charset=UTF-8");
		try {
			//图片读取路径
			in=new FileInputStream(url);
			int i=in.available();
			byte[]data=new byte[i];
			in.read(data);
			in.close();
			//写图片
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
			outputStream.write(data);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addReportSetting", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addReportSetting(@RequestBody JSONObject obj) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		
		try {
			//String jsonData = obj.getString("jsonData");
			//ReportSetting reportSetting = JsonUtils.jsonToPojo(jsonData, ReportSetting.class);
			ReportSetting reportSetting = JsonUtils.jsonToPojo(obj.toString(), ReportSetting.class);
			reportService.addReportSetting(reportSetting);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("",e);
			return AjaxResult.build(500, "error");
		}
		
		return AjaxResult.ok();
		
	}
	
	@RequestMapping(value = "/updateReportSetting", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateReportSetting(@RequestBody JSONObject obj) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		
		try {
			ReportSetting reportSetting = JsonUtils.jsonToPojo(obj.toString(), ReportSetting.class);
			reportService.updateReportSetting(reportSetting);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(500, "error");
		}
		
		return AjaxResult.ok();
	}
	
	@RequestMapping(value = "/deleteReportSetting", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteReportSetting(@RequestBody JSONObject obj) {
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysqlSqlite);
		
		try {
			int id = obj.getIntValue("id");
			String tableName = obj.getString("tableName");
			reportService.deleteReportSetting(id, tableName);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(500, "error");
		}
		
		return AjaxResult.ok();
	}
	
}
