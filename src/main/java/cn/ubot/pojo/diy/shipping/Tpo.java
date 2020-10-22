package cn.ubot.pojo.diy.shipping;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Tpo {
	private Integer id;
	private String customer;
	private String billTo;
	private String shipTo;
	private String tpo;
	private String customerPo;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createDate;
	private String terms;
	private String shipmode;
	private String requiredShipdate;
	private String createBy;
	private String updateBy;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;
	private String remark;
	private Integer qty;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getBillTo() {
		return this.billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getShipTo() {
		return this.shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getTpo() {
		return this.tpo;
	}

	public void setTpo(String tpo) {
		this.tpo = tpo;
	}

	public String getCustomerPo() {
		return this.customerPo;
	}

	public void setCustomerPo(String customerPo) {
		this.customerPo = customerPo;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTerms() {
		return this.terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getShipmode() {
		return this.shipmode;
	}

	public void setShipmode(String shipmode) {
		this.shipmode = shipmode;
	}

	public String getRequiredShipdate() {
		return this.requiredShipdate;
	}

	public void setRequiredShipdate(String requiredShipdate) {
		this.requiredShipdate = requiredShipdate;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getQty() {
		return this.qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
