package cn.ubot.pojo.diy;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportSetting {
	
	private int id;
	private String productNumber;
	private String tableName;
	private String lotNumberColumnName;
	private int linkCount;
	private List<ParamDetail> paramDetail;

}
