package cn.ubot.pojo.diy.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Jo_ {
	private Integer id;
	private Integer item;
	private String ubotJo;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date date;
	private String customerName;
	private String region;
	private String custPn;
	private String ubotPn;
	private String desc;
	private String uom;
	private String orderQuantity;
	private String createBy;
	private String updateBy;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;
	private Integer status;
	private String remarks;
	private String total;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getUbotJo() {
		return this.ubotJo;
	}

	public void setUbotJo(String ubotJo) {
		this.ubotJo = ubotJo;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCustPn() {
		return this.custPn;
	}

	public void setCustPn(String custPn) {
		this.custPn = custPn;
	}

	public String getUbotPn() {
		return this.ubotPn;
	}

	public void setUbotPn(String ubotPn) {
		this.ubotPn = ubotPn;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getOrderQuantity() {
		return this.orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
