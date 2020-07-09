/*     */ package cn.ubot.pojo.diy.user;
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
/*     */ public class UserRole_
/*     */ {
/*     */   private Long id;
/*     */   private String userName;
/*     */   private String password;
/*     */   private String salt;
/*     */   private Integer status;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date createTime;
/*     */   @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
/*     */   private Date updateTime;
/*     */   private Integer roleId;
/*     */   private String roleName;
/*     */   private String desc;
/*     */   
/*  33 */   public Long getId() { return this.id; }
/*     */ 
/*     */ 
/*     */   
/*  37 */   public void setId(Long id) { this.id = id; }
/*     */ 
/*     */ 
/*     */   
/*  41 */   public String getUserName() { return this.userName; }
/*     */ 
/*     */ 
/*     */   
/*  45 */   public void setUserName(String userName) { this.userName = userName; }
/*     */ 
/*     */ 
/*     */   
/*  49 */   public String getPassword() { return this.password; }
/*     */ 
/*     */ 
/*     */   
/*  53 */   public void setPassword(String password) { this.password = password; }
/*     */ 
/*     */ 
/*     */   
/*  57 */   public String getSalt() { return this.salt; }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public void setSalt(String salt) { this.salt = salt; }
/*     */ 
/*     */ 
/*     */   
/*  65 */   public Integer getStatus() { return this.status; }
/*     */ 
/*     */ 
/*     */   
/*  69 */   public void setStatus(Integer status) { this.status = status; }
/*     */ 
/*     */ 
/*     */   
/*  73 */   public Date getCreateTime() { return this.createTime; }
/*     */ 
/*     */ 
/*     */   
/*  77 */   public void setCreateTime(Date createTime) { this.createTime = createTime; }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public Date getUpdateTime() { return this.updateTime; }
/*     */ 
/*     */ 
/*     */   
/*  85 */   public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
/*     */ 
/*     */ 
/*     */   
/*  89 */   public String getRoleName() { return this.roleName; }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public void setRoleName(String roleName) { this.roleName = roleName; }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public String getDesc() { return this.desc; }
/*     */ 
/*     */ 
/*     */   
/* 101 */   public void setDesc(String desc) { this.desc = desc; }
/*     */ 
/*     */ 
/*     */   
/* 105 */   public Integer getRoleId() { return this.roleId; }
/*     */ 
/*     */ 
/*     */   
/* 109 */   public void setRoleId(Integer roleId) { this.roleId = roleId; }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\pojo\di\\user\UserRole_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */