package cn.ubot.pojo.diy;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamDetail {
	
	private int id;
	private int link;
	private String similarityColumnName;
	private int rsId;
	private List<ColumnDetail> columnDetail;
	
}
