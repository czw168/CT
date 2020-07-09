package cn.ubot.pojo.generator;

import java.util.Date;

public class Jo {
    private Integer id;

    private Integer item;

    private String ubotJo;

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

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getUbotJo() {
        return ubotJo;
    }

    public void setUbotJo(String ubotJo) {
        this.ubotJo = ubotJo == null ? null : ubotJo.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getCustPn() {
        return custPn;
    }

    public void setCustPn(String custPn) {
        this.custPn = custPn == null ? null : custPn.trim();
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

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom == null ? null : uom.trim();
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity == null ? null : orderQuantity.trim();
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}