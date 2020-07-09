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
/*     */ public class Jo_
/*     */ {
/*     */   private Integer id;
/*     */   private Integer item;
/*     */   private String ubotJo;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date date;
/*     */   private String customerName;
/*     */   private String region;
/*     */   private String custPn;
/*     */   private String ubotPn;
/*     */   private String desc;
/*     */   private String uom;
/*     */   private String orderQuantity;
/*     */   private String createBy;
/*     */   private String updateBy;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date createTime;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date updateTime;
/*     */   private Integer status;
/*     */   private String remarks;
/*     */   private String total;
/*     */   
/*  45 */   public Integer getId() { return this.id; }
/*     */ 
/*     */ 
/*     */   
/*  49 */   public void setId(Integer id) { this.id = id; }
/*     */ 
/*     */ 
/*     */   
/*  53 */   public Integer getItem() { return this.item; }
/*     */ 
/*     */ 
/*     */   
/*  57 */   public void setItem(Integer item) { this.item = item; }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public String getUbotJo() { return this.ubotJo; }
/*     */ 
/*     */ 
/*     */   
/*  65 */   public void setUbotJo(String ubotJo) { this.ubotJo = ubotJo; }
/*     */ 
/*     */ 
/*     */   
/*  69 */   public Date getDate() { return this.date; }
/*     */ 
/*     */ 
/*     */   
/*  73 */   public void setDate(Date date) { this.date = date; }
/*     */ 
/*     */ 
/*     */   
/*  77 */   public String getCustomerName() { return this.customerName; }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public void setCustomerName(String customerName) { this.customerName = customerName; }
/*     */ 
/*     */ 
/*     */   
/*  85 */   public String getRegion() { return this.region; }
/*     */ 
/*     */ 
/*     */   
/*  89 */   public void setRegion(String region) { this.region = region; }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public String getCustPn() { return this.custPn; }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public void setCustPn(String custPn) { this.custPn = custPn; }
/*     */ 
/*     */ 
/*     */   
/* 101 */   public String getUbotPn() { return this.ubotPn; }
/*     */ 
/*     */ 
/*     */   
/* 105 */   public void setUbotPn(String ubotPn) { this.ubotPn = ubotPn; }
/*     */ 
/*     */ 
/*     */   
/* 109 */   public String getDesc() { return this.desc; }
/*     */ 
/*     */ 
/*     */   
/* 113 */   public void setDesc(String desc) { this.desc = desc; }
/*     */ 
/*     */ 
/*     */   
/* 117 */   public String getUom() { return this.uom; }
/*     */ 
/*     */ 
/*     */   
/* 121 */   public void setUom(String uom) { this.uom = uom; }
/*     */ 
/*     */ 
/*     */   
/* 125 */   public String getOrderQuantity() { return this.orderQuantity; }
/*     */ 
/*     */ 
/*     */   
/* 129 */   public void setOrderQuantity(String orderQuantity) { this.orderQuantity = orderQuantity; }
/*     */ 
/*     */ 
/*     */   
/* 133 */   public String getCreateBy() { return this.createBy; }
/*     */ 
/*     */ 
/*     */   
/* 137 */   public void setCreateBy(String createBy) { this.createBy = createBy; }
/*     */ 
/*     */ 
/*     */   
/* 141 */   public String getUpdateBy() { return this.updateBy; }
/*     */ 
/*     */ 
/*     */   
/* 145 */   public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
/*     */ 
/*     */ 
/*     */   
/* 149 */   public Date getCreateTime() { return this.createTime; }
/*     */ 
/*     */ 
/*     */   
/* 153 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */ 
/*     */ 
/*     */   
/* 157 */   public Date getUpdateTime() { return this.updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 161 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 165 */   public Integer getStatus() { return this.status; }
/*     */ 
/*     */ 
/*     */   
/* 169 */   public void setStatus(Integer status) { this.status = status; }
/*     */ 
/*     */ 
/*     */   
/* 173 */   public String getRemarks() { return this.remarks; }
/*     */ 
/*     */ 
/*     */   
/* 177 */   public void setRemarks(String remarks) { this.remarks = remarks; }
/*     */ 
/*     */ 
/*     */   
/* 181 */   public String getTotal() { return this.total; }
/*     */ 
/*     */ 
/*     */   
/* 185 */   public void setTotal(String total) { this.total = total; }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\pojo\diy\production\Jo_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */