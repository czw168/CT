package cn.ubot.pojo.diy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDetail {

	private String columnName;
	private String alias;
	private String group;
	private int pdId;
	
}
