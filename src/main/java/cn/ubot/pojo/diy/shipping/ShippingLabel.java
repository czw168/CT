/*    */ package cn.ubot.pojo.diy.shipping;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShippingLabel
/*    */ {
/*    */   private Integer id;
/*    */   private String shipLot;
/*    */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*    */   private Date shipDate;
/*    */   private Integer cartons;
/*    */   private String createBy;
/*    */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*    */   private Date createTime;
/*    */   private String updateBy;
/*    */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*    */   private Date updateTime;
/*    */   private Integer qty;
/*    */   
/* 31 */   public Integer getId() { return this.id; }
/*    */ 
/*    */ 
/*    */   
/* 35 */   public void setId(Integer id) { this.id = id; }
/*    */ 
/*    */ 
/*    */   
/* 39 */   public String getShipLot() { return this.shipLot; }
/*    */ 
/*    */ 
/*    */   
/* 43 */   public void setShipLot(String shipLot) { this.shipLot = shipLot; }
/*    */ 
/*    */ 
/*    */   
/* 47 */   public Date getShipDate() { return this.shipDate; }
/*    */ 
/*    */ 
/*    */   
/* 51 */   public void setShipDate(Date shipDate) { this.shipDate = shipDate; }
/*    */ 
/*    */ 
/*    */   
/* 55 */   public Integer getCartons() { return this.cartons; }
/*    */ 
/*    */ 
/*    */   
/* 59 */   public void setCartons(Integer cartons) { this.cartons = cartons; }
/*    */ 
/*    */ 
/*    */   
/* 63 */   public String getCreateBy() { return this.createBy; }
/*    */ 
/*    */ 
/*    */   
/* 67 */   public void setCreateBy(String createBy) { this.createBy = createBy; }
/*    */ 
/*    */ 
/*    */   
/* 71 */   public Date getCreateTime() { return this.createTime; }
/*    */ 
/*    */ 
/*    */   
/* 75 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*    */ 
/*    */ 
/*    */   
/* 79 */   public String getUpdateBy() { return this.updateBy; }
/*    */ 
/*    */ 
/*    */   
/* 83 */   public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
/*    */ 
/*    */ 
/*    */   
/* 87 */   public Date getUpdateTime() { return this.updateTime; }
/*    */ 
/*    */ 
/*    */   
/* 91 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*    */ 
/*    */ 
/*    */   
/* 95 */   public Integer getQty() { return this.qty; }
/*    */ 
/*    */ 
/*    */   
/* 99 */   public void setQty(Integer qty) { this.qty = qty; }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\pojo\diy\shipping\ShippingLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */