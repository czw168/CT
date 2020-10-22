package cn.ubot.common;
/**
 * easyui下拉框返回格式
 * @author victor_chen
 *
 */
public class EUComboBoxResult {
	private String id;
	private String text;
	private String desc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public EUComboBoxResult(String id, String text, String desc) {
		super();
		this.id = id;
		this.text = text;
		this.desc = desc;
	}
	public EUComboBoxResult() {
		super();
	}
	
}
