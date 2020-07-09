/*     */ package cn.ubot.commin;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.JsonNode;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AjaxResult
/*     */ {
/*  15 */   private static final ObjectMapper MAPPER = new ObjectMapper();
/*     */ 
/*     */   
/*     */   private Integer status;
/*     */ 
/*     */   
/*     */   private String msg;
/*     */ 
/*     */   
/*     */   private Object data;
/*     */ 
/*     */   
/*  27 */   public static AjaxResult build(Integer status, String msg, Object data) { return new AjaxResult(status, msg, data); }
/*     */ 
/*     */ 
/*     */   
/*  31 */   public static AjaxResult ok(Object data) { return new AjaxResult(data); }
/*     */ 
/*     */ 
/*     */   
/*  35 */   public static AjaxResult ok() { return new AjaxResult(null); }
/*     */ 
/*     */ 
/*     */   
/*     */   public AjaxResult() {}
/*     */ 
/*     */ 
/*     */   
/*  43 */   public static AjaxResult build(Integer status, String msg) { return new AjaxResult(status, msg, null); }
/*     */ 
/*     */   
/*     */   public AjaxResult(Integer status, String msg, Object data) {
/*  47 */     this.status = status;
/*  48 */     this.msg = msg;
/*  49 */     this.data = data;
/*     */   }
/*     */   
/*     */   public AjaxResult(Object data) {
/*  53 */     this.status = Integer.valueOf(200);
/*  54 */     this.msg = "OK";
/*  55 */     this.data = data;
/*     */   }
/*     */ 
/*     */   
/*  59 */   public Integer getStatus() { return this.status; }
/*     */ 
/*     */ 
/*     */   
/*  63 */   public void setStatus(Integer status) { this.status = status; }
/*     */ 
/*     */ 
/*     */   
/*  67 */   public String getMsg() { return this.msg; }
/*     */ 
/*     */ 
/*     */   
/*  71 */   public void setMsg(String msg) { this.msg = msg; }
/*     */ 
/*     */ 
/*     */   
/*  75 */   public Object getData() { return this.data; }
/*     */ 
/*     */ 
/*     */   
/*  79 */   public void setData(Object data) { this.data = data; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AjaxResult formatToPojo(String jsonData, Class<?> clazz) {
/*     */     try {
/*  91 */       if (clazz == null) {
/*  92 */         return (AjaxResult)MAPPER.readValue(jsonData, AjaxResult.class);
/*     */       }
/*  94 */       JsonNode jsonNode = MAPPER.readTree(jsonData);
/*  95 */       JsonNode data = jsonNode.get("data");
/*  96 */       Object obj = null;
/*  97 */       if (clazz != null) {
/*  98 */         if (data.isObject()) {
/*  99 */           obj = MAPPER.readValue(data.traverse(), clazz);
/* 100 */         } else if (data.isTextual()) {
/* 101 */           obj = MAPPER.readValue(data.asText(), clazz);
/*     */         } 
/*     */       }
/* 104 */       return build(Integer.valueOf(jsonNode.get("status").intValue()), jsonNode.get("msg").asText(), obj);
/* 105 */     } catch (Exception e) {
/* 106 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AjaxResult format(String json) {
/*     */     try {
/* 118 */       return (AjaxResult)MAPPER.readValue(json, AjaxResult.class);
/* 119 */     } catch (Exception e) {
/* 120 */       e.printStackTrace();
/*     */       
/* 122 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AjaxResult formatToList(String jsonData, Class<?> clazz) {
/*     */     try {
/* 134 */       JsonNode jsonNode = MAPPER.readTree(jsonData);
/* 135 */       JsonNode data = jsonNode.get("data");
/* 136 */       Object obj = null;
/* 137 */       if (data.isArray() && data.size() > 0) {
/* 138 */         obj = MAPPER.readValue(data.traverse(), MAPPER
/* 139 */             .getTypeFactory().constructCollectionType(java.util.List.class, clazz));
/*     */       }
/* 141 */       return build(Integer.valueOf(jsonNode.get("status").intValue()), jsonNode.get("msg").asText(), obj);
/* 142 */     } catch (Exception e) {
/* 143 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\commin\AjaxResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */