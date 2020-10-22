package cn.ubot.pojo.diy.production;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Ltc_ {
	private Integer id;
	private String ltc;
	private String joNo;
	private String ubotPn;
	private String desc;
	private String customerName;
	private String custPn;
	private Integer lane;
	private String machine;
	private String puchingTool;
	private String materialLot;
	private String sourceBatchCode;
	private String lotType;
	private String productType;
	private String createBy;
	private String updateBy;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date productionDate;
	private String lotSerics;
	private String sublotSerics;
	private String formingTool;
	private String scittingTool;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;
	private String remarks;

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
		this.ltc = (ltc == null) ? null : ltc.trim();
	}

	public String getJoNo() {
		return this.joNo;
	}

	public void setJoNo(String joNo) {
		this.joNo = (joNo == null) ? null : joNo.trim();
	}

	public String getUbotPn() {
		return this.ubotPn;
	}

	public void setUbotPn(String ubotPn) {
		this.ubotPn = (ubotPn == null) ? null : ubotPn.trim();
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = (desc == null) ? null : desc.trim();
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = (customerName == null) ? null : customerName.trim();
	}

	public String getCustPn() {
		return this.custPn;
	}

	public void setCustPn(String custPn) {
		this.custPn = (custPn == null) ? null : custPn.trim();
	}

	public Integer getLane() {
		return this.lane;
	}

	public void setLane(Integer lane) {
		this.lane = lane;
	}

	public String getMachine() {
		return this.machine;
	}

	public void setMachine(String machine) {
		this.machine = (machine == null) ? null : machine.trim();
	}

	public String getPuchingTool() {
		return this.puchingTool;
	}

	public void setPuchingTool(String puchingTool) {
		this.puchingTool = (puchingTool == null) ? null : puchingTool.trim();
	}

	public String getMaterialLot() {
		return this.materialLot;
	}

	public void setMaterialLot(String materialLot) {
		this.materialLot = (materialLot == null) ? null : materialLot.trim();
	}

	public String getSourceBatchCode() {
		return this.sourceBatchCode;
	}

	public void setSourceBatchCode(String sourceBatchCode) {
		this.sourceBatchCode = (sourceBatchCode == null) ? null : sourceBatchCode.trim();
	}

	public String getLotType() {
		return this.lotType;
	}

	public void setLotType(String lotType) {
		this.lotType = (lotType == null) ? null : lotType.trim();
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = (productType == null) ? null : productType.trim();
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = (createBy == null) ? null : createBy.trim();
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = (updateBy == null) ? null : updateBy.trim();
	}

	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public String getLotSerics() {
		return this.lotSerics;
	}

	public void setLotSerics(String lotSerics) {
		this.lotSerics = (lotSerics == null) ? null : lotSerics.trim();
	}

	public String getSublotSerics() {
		return this.sublotSerics;
	}

	public void setSublotSerics(String sublotSerics) {
		this.sublotSerics = (sublotSerics == null) ? null : sublotSerics.trim();
	}

	public String getFormingTool() {
		return this.formingTool;
	}

	public void setFormingTool(String formingTool) {
		this.formingTool = (formingTool == null) ? null : formingTool.trim();
	}

	public String getScittingTool() {
		return this.scittingTool;
	}

	public void setScittingTool(String scittingTool) {
		this.scittingTool = (scittingTool == null) ? null : scittingTool.trim();
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = (remarks == null) ? null : remarks.trim();
	}
}
