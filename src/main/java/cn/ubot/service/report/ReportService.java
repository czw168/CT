package cn.ubot.service.report;

import java.util.List;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.diy.ReportSetting;

public interface ReportService {

	EUDataGridResult getReport1(Integer page,Integer rows,String date);
	
	AjaxResult getLineChartData(String lotNo);
	
	List<EUComboBoxResult> getProductNo();
	
	List<EUComboBoxResult> getInspectionID();
	
	AjaxResult getReportSetting(String productNumber,String tableName);
	
	AjaxResult getDatagrid(String date, String table);
	
	EUDataGridResult getReportSettings(String productNumber);
	
	EUDataGridResult getReport3(String lotNo,String table);
	
	EUDataGridResult getReport4(String date,String table);
	
	void addReportSetting(ReportSetting reportSetting);

	void updateReportSetting(ReportSetting reportSetting);
	
	void deleteReportSetting(int id,String tableName);
	
}
