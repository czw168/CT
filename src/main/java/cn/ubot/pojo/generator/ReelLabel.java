package cn.ubot.pojo.generator;

import java.util.Date;

public class ReelLabel {
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

    private Date productionDate;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLtc() {
        return ltc;
    }

    public void setLtc(String ltc) {
        this.ltc = ltc == null ? null : ltc.trim();
    }

    public String getUbotPn() {
        return ubotPn;
    }

    public void setUbotPn(String ubotPn) {
        this.ubotPn = ubotPn == null ? null : ubotPn.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane == null ? null : lane.trim();
    }

    public String getJoNo() {
        return joNo;
    }

    public void setJoNo(String joNo) {
        this.joNo = joNo == null ? null : joNo.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustPn() {
        return custPn;
    }

    public void setCustPn(String custPn) {
        this.custPn = custPn == null ? null : custPn.trim();
    }

    public Integer getBatches() {
        return batches;
    }

    public void setBatches(Integer batches) {
        this.batches = batches;
    }

    public String getMaterialLot() {
        return materialLot;
    }

    public void setMaterialLot(String materialLot) {
        this.materialLot = materialLot == null ? null : materialLot.trim();
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }

    public String getPuchingTool() {
        return puchingTool;
    }

    public void setPuchingTool(String puchingTool) {
        this.puchingTool = puchingTool == null ? null : puchingTool.trim();
    }

    public String getFormingTool() {
        return formingTool;
    }

    public void setFormingTool(String formingTool) {
        this.formingTool = formingTool == null ? null : formingTool.trim();
    }

    public String getScittingTool() {
        return scittingTool;
    }

    public void setScittingTool(String scittingTool) {
        this.scittingTool = scittingTool == null ? null : scittingTool.trim();
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}