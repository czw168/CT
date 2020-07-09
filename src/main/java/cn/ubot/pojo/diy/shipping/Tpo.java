/*     */ package cn.ubot.pojo.diy.shipping;
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
/*     */ public class Tpo
/*     */ {
/*     */   private Integer id;
/*     */   private String customer;
/*     */   private String billTo;
/*     */   private String shipTo;
/*     */   private String tpo;
/*     */   private String customerPo;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date createDate;
/*     */   private String terms;
/*     */   private String shipmode;
/*     */   private String requiredShipdate;
/*     */   private String createBy;
/*     */   private String updateBy;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date createTime;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date updateTime;
/*     */   private String remark;
/*     */   private Integer qty;
/*     */   
/*  46 */   public Integer getId() { return this.id; }
/*     */ 
/*     */ 
/*     */   
/*  50 */   public void setId(Integer id) { this.id = id; }
/*     */ 
/*     */ 
/*     */   
/*  54 */   public String getCustomer() { return this.customer; }
/*     */ 
/*     */ 
/*     */   
/*  58 */   public void setCustomer(String customer) { this.customer = customer; }
/*     */ 
/*     */ 
/*     */   
/*  62 */   public String getBillTo() { return this.billTo; }
/*     */ 
/*     */ 
/*     */   
/*  66 */   public void setBillTo(String billTo) { this.billTo = billTo; }
/*     */ 
/*     */ 
/*     */   
/*  70 */   public String getShipTo() { return this.shipTo; }
/*     */ 
/*     */ 
/*     */   
/*  74 */   public void setShipTo(String shipTo) { this.shipTo = shipTo; }
/*     */ 
/*     */ 
/*     */   
/*  78 */   public String getTpo() { return this.tpo; }
/*     */ 
/*     */ 
/*     */   
/*  82 */   public void setTpo(String tpo) { this.tpo = tpo; }
/*     */ 
/*     */ 
/*     */   
/*  86 */   public String getCustomerPo() { return this.customerPo; }
/*     */ 
/*     */ 
/*     */   
/*  90 */   public void setCustomerPo(String customerPo) { this.customerPo = customerPo; }
/*     */ 
/*     */ 
/*     */   
/*  94 */   public Date getCreateDate() { return this.createDate; }
/*     */ 
/*     */ 
/*     */   
/*  98 */   public void setCreateDate(Date createDate) { this.createDate = createDate; }
/*     */ 
/*     */ 
/*     */   
/* 102 */   public String getTerms() { return this.terms; }
/*     */ 
/*     */ 
/*     */   
/* 106 */   public void setTerms(String terms) { this.terms = terms; }
/*     */ 
/*     */ 
/*     */   
/* 110 */   public String getShipmode() { return this.shipmode; }
/*     */ 
/*     */ 
/*     */   
/* 114 */   public void setShipmode(String shipmode) { this.shipmode = shipmode; }
/*     */ 
/*     */ 
/*     */   
/* 118 */   public String getRequiredShipdate() { return this.requiredShipdate; }
/*     */ 
/*     */ 
/*     */   
/* 122 */   public void setRequiredShipdate(String requiredShipdate) { this.requiredShipdate = requiredShipdate; }
/*     */ 
/*     */ 
/*     */   
/* 126 */   public String getCreateBy() { return this.createBy; }
/*     */ 
/*     */ 
/*     */   
/* 130 */   public void setCreateBy(String createBy) { this.createBy = createBy; }
/*     */ 
/*     */ 
/*     */   
/* 134 */   public String getUpdateBy() { return this.updateBy; }
/*     */ 
/*     */ 
/*     */   
/* 138 */   public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
/*     */ 
/*     */ 
/*     */   
/* 142 */   public Date getCreateTime() { return this.createTime; }
/*     */ 
/*     */ 
/*     */   
/* 146 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */ 
/*     */ 
/*     */   
/* 150 */   public Date getUpdateTime() { return this.updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 154 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*     */ 
/*     */ 
/*     */   
/* 158 */   public String getRemark() { return this.remark; }
/*     */ 
/*     */ 
/*     */   
/* 162 */   public void setRemark(String remark) { this.remark = remark; }
/*     */ 
/*     */ 
/*     */   
/* 166 */   public Integer getQty() { return this.qty; }
/*     */ 
/*     */ 
/*     */   
/* 170 */   public void setQty(Integer qty) { this.qty = qty; }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\pojo\diy\shipping\Tpo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */