package cn.ubot.common;

import java.util.List;
/**
 * easyUi数据表格返回格式(增加底部统计)
 * @author victor_chen
 *
 */
public class EUDataGridFootResult {

	private long total;
	private List<?> rows;
	private List<?> footer;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public List<?> getFooter() {
		return footer;
	}
	public void setFooter(List<?> footer) {
		this.footer = footer;
	}
	
	
	
	
	
}
