package cn.ubot.pojo.diy.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class PackingLtc {
	private Integer id;
	private String ltc;
	private String carton;
	private Integer qty;
	private String q1;
	private String q2;
	private String q3;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date packingDate;
	private String createBy;
	private String updateBy;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;
	private String ubotPn;
	private String desc;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLtc() {
		return this.ltc;
	}

	public void setLtc(String ltc) {
		this.ltc = ltc;
	}

	public String getCarton() {
		return this.carton;
	}

	public void setCarton(String carton) {
		this.carton = carton;
	}

	public Integer getQty() {
		return this.qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getQ1() {
		return this.q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return this.q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return this.q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public Date getPackingDate() {
		return this.packingDate;
	}

	public void setPackingDate(Date packingDate) {
		this.packingDate = packingDate;
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
}
