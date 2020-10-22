package cn.ubot.pojo.diy;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * report-list3.jsp 的数据返回对象
 * @author victor_chen
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqliteResult3 {
	
	private int aCount;
	private int bCount;
	private int cCount;
	private List<String> pictureAUrls;
	private List<String> pictureBUrls;
	private List<String> pictureCUrls;
	
}
