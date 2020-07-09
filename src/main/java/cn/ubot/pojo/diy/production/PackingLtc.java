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
/*     */ public class PackingLtc
/*     */ {
/*     */   private Integer id;
/*     */   private String ltc;
/*     */   private String carton;
/*     */   private Integer qty;
/*     */   private String q1;
/*     */   private String q2;
/*     */   private String q3;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date packingDate;
/*     */   private String createBy;
/*     */   private String updateBy;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date createTime;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date updateTime;
/*     */   private String ubotPn;
/*     */   private String desc;
/*     */   
/*  31 */   public Integer getId() { return this.id; }
/*     */ 
/*     */   
/*  34 */   public void setId(Integer id) { this.id = id; }
/*     */ 
/*     */   
/*  37 */   public String getLtc() { return this.ltc; }
/*     */ 
/*     */   
/*  40 */   public void setLtc(String ltc) { this.ltc = ltc; }
/*     */ 
/*     */   
/*  43 */   public String getCarton() { return this.carton; }
/*     */ 
/*     */   
/*  46 */   public void setCarton(String carton) { this.carton = carton; }
/*     */ 
/*     */   
/*  49 */   public Integer getQty() { return this.qty; }
/*     */ 
/*     */   
/*  52 */   public void setQty(Integer qty) { this.qty = qty; }
/*     */ 
/*     */   
/*  55 */   public String getQ1() { return this.q1; }
/*     */ 
/*     */   
/*  58 */   public void setQ1(String q1) { this.q1 = q1; }
/*     */ 
/*     */   
/*  61 */   public String getQ2() { return this.q2; }
/*     */ 
/*     */   
/*  64 */   public void setQ2(String q2) { this.q2 = q2; }
/*     */ 
/*     */   
/*  67 */   public String getQ3() { return this.q3; }
/*     */ 
/*     */   
/*  70 */   public void setQ3(String q3) { this.q3 = q3; }
/*     */ 
/*     */   
/*  73 */   public Date getPackingDate() { return this.packingDate; }
/*     */ 
/*     */   
/*  76 */   public void setPackingDate(Date packingDate) { this.packingDate = packingDate; }
/*     */ 
/*     */   
/*  79 */   public String getCreateBy() { return this.createBy; }
/*     */ 
/*     */   
/*  82 */   public void setCreateBy(String createBy) { this.createBy = createBy; }
/*     */ 
/*     */   
/*  85 */   public String getUpdateBy() { return this.updateBy; }
/*     */ 
/*     */   
/*  88 */   public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
/*     */ 
/*     */   
/*  91 */   public Date getCreateTime() { return this.createTime; }
/*     */ 
/*     */   
/*  94 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */ 
/*     */   
/*  97 */   public Date getUpdateTime() { return this.updateTime; }
/*     */ 
/*     */   
/* 100 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*     */ 
/*     */   
/* 103 */   public String getUbotPn() { return this.ubotPn; }
/*     */ 
/*     */   
/* 106 */   public void setUbotPn(String ubotPn) { this.ubotPn = ubotPn; }
/*     */ 
/*     */   
/* 109 */   public String getDesc() { return this.desc; }
/*     */ 
/*     */   
/* 112 */   public void setDesc(String desc) { this.desc = desc; }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\pojo\diy\production\PackingLtc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */