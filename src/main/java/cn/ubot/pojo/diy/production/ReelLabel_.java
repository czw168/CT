package cn.ubot.pojo.diy.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class ReelLabel_ {
	private Long id;
	private String ltc;
	private String ubotPn;
	private String desc;
	private String lane;
	private String joNo;
	private String customerName;
	private String custPn;
	private Integer batches;
	private String materialLot;
	private String machine;
	private String puchingTool;
	private String formingTool;
	private String scittingTool;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date productionDate;
	private String createBy;
	private String updateBy;
	private Date createTime;
	private Date updateTime;
	private Integer status;
	private String lotNo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLtc() {
		return this.ltc;
	}

	public void setLtc(String ltc) {
		this.ltc = ltc;
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

	public String getLane() {
		return this.lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getJoNo() {
		return this.joNo;
	}

	public void setJoNo(String joNo) {
		this.joNo = joNo;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustPn() {
		return this.custPn;
	}

	public void setCustPn(String custPn) {
		this.custPn = custPn;
	}

	public Integer getBatches() {
		return this.batches;
	}

	public void setBatches(Integer batches) {
		this.batches = batches;
	}

	public String getMaterialLot() {
		return this.materialLot;
	}

	public void setMaterialLot(String materialLot) {
		this.materialLot = materialLot;
	}

	public String getMachine() {
		return this.machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getPuchingTool() {
		return this.puchingTool;
	}

	public void setPuchingTool(String puchingTool) {
		this.puchingTool = puchingTool;
	}

	public String getFormingTool() {
		return this.formingTool;
	}

	public void setFormingTool(String formingTool) {
		this.formingTool = formingTool;
	}

	public String getScittingTool() {
		return this.scittingTool;
	}

	public void setScittingTool(String scittingTool) {
		this.scittingTool = scittingTool;
	}

	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
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

	public String getLotNo() {
		return this.lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
}
