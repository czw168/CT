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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReelLabel_
/*     */ {
/*     */   private Long id;
/*     */   private String ltc;
/*     */   private String ubotPn;
/*     */   private String desc;
/*     */   private String lane;
/*     */   private String joNo;
/*     */   private String customerName;
/*     */   private String custPn;
/*     */   private Integer batches;
/*     */   private String materialLot;
/*     */   private String machine;
/*     */   private String puchingTool;
/*     */   private String formingTool;
/*     */   private String scittingTool;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date productionDate;
/*     */   private String createBy;
/*     */   private String updateBy;
/*     */   private Date createTime;
/*     */   private Date updateTime;
/*     */   private Integer status;
/*     */   private String lotNo;
/*     */   
/*  57 */   public Long getId() { return this.id; }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public void setId(Long id) { this.id = id; }
/*     */ 
/*     */ 
/*     */   
/*  65 */   public String getLtc() { return this.ltc; }
/*     */ 
/*     */ 
/*     */   
/*  69 */   public void setLtc(String ltc) { this.ltc = ltc; }
/*     */ 
/*     */ 
/*     */   
/*  73 */   public String getUbotPn() { return this.ubotPn; }
/*     */ 
/*     */ 
/*     */   
/*  77 */   public void setUbotPn(String ubotPn) { this.ubotPn = ubotPn; }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public String getDesc() { return this.desc; }
/*     */ 
/*     */ 
/*     */   
/*  85 */   public void setDesc(String desc) { this.desc = desc; }
/*     */ 
/*     */ 
/*     */   
/*  89 */   public String getLane() { return this.lane; }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public void setLane(String lane) { this.lane = lane; }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public String getJoNo() { return this.joNo; }
/*     */ 
/*     */ 
/*     */   
/* 101 */   public void setJoNo(String joNo) { this.joNo = joNo; }
/*     */ 
/*     */ 
/*     */   
/* 105 */   public String getCustomerName() { return this.customerName; }
/*     */ 
/*     */ 
/*     */   
/* 109 */   public void setCustomerName(String customerName) { this.customerName = customerName; }
/*     */ 
/*     */ 
/*     */   
/* 113 */   public String getCustPn() { return this.custPn; }
/*     */ 
/*     */ 
/*     */   
/* 117 */   public void setCustPn(String custPn) { this.custPn = custPn; }
/*     */ 
/*     */ 
/*     */   
/* 121 */   public Integer getBatches() { return this.batches; }
/*     */ 
/*     */ 
/*     */   
/* 125 */   public void setBatches(Integer batches) { this.batches = batches; }
/*     */ 
/*     */ 
/*     */   
/* 129 */   public String getMaterialLot() { return this.materialLot; }
/*     */ 
/*     */ 
/*     */   
/* 133 */   public void setMaterialLot(String materialLot) { this.materialLot = materialLot; }
/*     */ 
/*     */ 
/*     */   
/* 137 */   public String getMachine() { return this.machine; }
/*     */ 
/*     */ 
/*     */   
/* 141 */   public void setMachine(String machine) { this.machine = machine; }
/*     */ 
/*     */ 
/*     */   
/* 145 */   public String getPuchingTool() { return this.puchingTool; }
/*     */ 
/*     */ 
/*     */   
/* 149 */   public void setPuchingTool(String puchingTool) { this.puchingTool = puchingTool; }
/*     */ 
/*     */ 
/*     */   
/* 153 */   public String getFormingTool() { return this.formingTool; }
/*     */ 
/*     */ 
/*     */   
/* 157 */   public void setFormingTool(String formingTool) { this.formingTool = formingTool; }
/*     */ 
/*     */ 
/*     */   
/* 161 */   public String getScittingTool() { return this.scittingTool; }
/*     */ 
/*     */ 
/*     */   
/* 165 */   public void setScittingTool(String scittingTool) { this.scittingTool = scittingTool; }
/*     */ 
/*     */ 
/*     */   
/* 169 */   public Date getProductionDate() { return this.productionDate; }
/*     */ 
/*     */ 
/*     */   
/* 173 */   public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }
/*     */ 
/*     */ 
/*     */   
/* 177 */   public String getCreateBy() { return this.createBy; }
/*     */ 
/*     */ 
/*     */   
/* 181 */   public void setCreateBy(String createBy) { this.createBy = createBy; }
/*     */ 
/*     */ 
/*     */   
/* 185 */   public String getUpdateBy() { return this.updateBy; }
/*     */ 
/*     */ 
/*     */   
/* 189 */   public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
/*     */ 
/*     */ 
/*     */   
/* 193 */   public Date getCreateTime() { return this.createTime; }
/*     */ 
/*     */ 
/*     */   
/* 197 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */ 
/*     */ 
/*     */   
/* 201 */   public Date getUpdateTime() { return this.updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 205 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 209 */   public Integer getStatus() { return this.status; }
/*     */ 
/*     */ 
/*     */   
/* 213 */   public void setStatus(Integer status) { this.status = status; }
/*     */ 
/*     */ 
/*     */   
/* 217 */   public String getLotNo() { return this.lotNo; }
/*     */ 
/*     */ 
/*     */   
/* 221 */   public void setLotNo(String lotNo) { this.lotNo = lotNo; }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\pojo\diy\production\ReelLabel_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */