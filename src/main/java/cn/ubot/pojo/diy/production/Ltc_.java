/*     */ package cn.ubot.pojo.diy.production;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ltc_
/*     */ {
/*     */   private Integer id;
/*     */   private String ltc;
/*     */   private String joNo;
/*     */   private String ubotPn;
/*     */   private String desc;
/*     */   private String customerName;
/*     */   private String custPn;
/*     */   private Integer lane;
/*     */   private String machine;
/*     */   private String puchingTool;
/*     */   private String materialLot;
/*     */   private String sourceBatchCode;
/*     */   private String lotType;
/*     */   private String productType;
/*     */   private String createBy;
/*     */   private String updateBy;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date productionDate;
/*     */   private String lotSerics;
/*     */   private String sublotSerics;
/*     */   private String formingTool;
/*     */   private String scittingTool;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date createTime;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date updateTime;
/*     */   private String remarks;
/*     */   
/*  57 */   public Integer getId() { return this.id; }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public void setId(Integer id) { this.id = id; }
/*     */ 
/*     */ 
/*     */   
/*  65 */   public String getLtc() { return this.ltc; }
/*     */ 
/*     */ 
/*     */   
/*  69 */   public void setLtc(String ltc) { this.ltc = (ltc == null) ? null : ltc.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  73 */   public String getJoNo() { return this.joNo; }
/*     */ 
/*     */ 
/*     */   
/*  77 */   public void setJoNo(String joNo) { this.joNo = (joNo == null) ? null : joNo.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public String getUbotPn() { return this.ubotPn; }
/*     */ 
/*     */ 
/*     */   
/*  85 */   public void setUbotPn(String ubotPn) { this.ubotPn = (ubotPn == null) ? null : ubotPn.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  89 */   public String getDesc() { return this.desc; }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public void setDesc(String desc) { this.desc = (desc == null) ? null : desc.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public String getCustomerName() { return this.customerName; }
/*     */ 
/*     */ 
/*     */   
/* 101 */   public void setCustomerName(String customerName) { this.customerName = (customerName == null) ? null : customerName.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 105 */   public String getCustPn() { return this.custPn; }
/*     */ 
/*     */ 
/*     */   
/* 109 */   public void setCustPn(String custPn) { this.custPn = (custPn == null) ? null : custPn.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 113 */   public Integer getLane() { return this.lane; }
/*     */ 
/*     */ 
/*     */   
/* 117 */   public void setLane(Integer lane) { this.lane = lane; }
/*     */ 
/*     */ 
/*     */   
/* 121 */   public String getMachine() { return this.machine; }
/*     */ 
/*     */ 
/*     */   
/* 125 */   public void setMachine(String machine) { this.machine = (machine == null) ? null : machine.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 129 */   public String getPuchingTool() { return this.puchingTool; }
/*     */ 
/*     */ 
/*     */   
/* 133 */   public void setPuchingTool(String puchingTool) { this.puchingTool = (puchingTool == null) ? null : puchingTool.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 137 */   public String getMaterialLot() { return this.materialLot; }
/*     */ 
/*     */ 
/*     */   
/* 141 */   public void setMaterialLot(String materialLot) { this.materialLot = (materialLot == null) ? null : materialLot.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 145 */   public String getSourceBatchCode() { return this.sourceBatchCode; }
/*     */ 
/*     */ 
/*     */   
/* 149 */   public void setSourceBatchCode(String sourceBatchCode) { this.sourceBatchCode = (sourceBatchCode == null) ? null : sourceBatchCode.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 153 */   public String getLotType() { return this.lotType; }
/*     */ 
/*     */ 
/*     */   
/* 157 */   public void setLotType(String lotType) { this.lotType = (lotType == null) ? null : lotType.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 161 */   public String getProductType() { return this.productType; }
/*     */ 
/*     */ 
/*     */   
/* 165 */   public void setProductType(String productType) { this.productType = (productType == null) ? null : productType.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 169 */   public String getCreateBy() { return this.createBy; }
/*     */ 
/*     */ 
/*     */   
/* 173 */   public void setCreateBy(String createBy) { this.createBy = (createBy == null) ? null : createBy.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 177 */   public String getUpdateBy() { return this.updateBy; }
/*     */ 
/*     */ 
/*     */   
/* 181 */   public void setUpdateBy(String updateBy) { this.updateBy = (updateBy == null) ? null : updateBy.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 185 */   public Date getProductionDate() { return this.productionDate; }
/*     */ 
/*     */ 
/*     */   
/* 189 */   public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }
/*     */ 
/*     */ 
/*     */   
/* 193 */   public String getLotSerics() { return this.lotSerics; }
/*     */ 
/*     */ 
/*     */   
/* 197 */   public void setLotSerics(String lotSerics) { this.lotSerics = (lotSerics == null) ? null : lotSerics.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 201 */   public String getSublotSerics() { return this.sublotSerics; }
/*     */ 
/*     */ 
/*     */   
/* 205 */   public void setSublotSerics(String sublotSerics) { this.sublotSerics = (sublotSerics == null) ? null : sublotSerics.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 209 */   public String getFormingTool() { return this.formingTool; }
/*     */ 
/*     */ 
/*     */   
/* 213 */   public void setFormingTool(String formingTool) { this.formingTool = (formingTool == null) ? null : formingTool.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 217 */   public String getScittingTool() { return this.scittingTool; }
/*     */ 
/*     */ 
/*     */   
/* 221 */   public void setScittingTool(String scittingTool) { this.scittingTool = (scittingTool == null) ? null : scittingTool.trim(); }
/*     */ 
/*     */ 
/*     */   
/* 225 */   public Date getCreateTime() { return this.createTime; }
/*     */ 
/*     */ 
/*     */   
/* 229 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */ 
/*     */ 
/*     */   
/* 233 */   public Date getUpdateTime() { return this.updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 237 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 241 */   public String getRemarks() { return this.remarks; }
/*     */ 
/*     */ 
/*     */   
/* 245 */   public void setRemarks(String remarks) { this.remarks = (remarks == null) ? null : remarks.trim(); }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\pojo\diy\production\Ltc_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */