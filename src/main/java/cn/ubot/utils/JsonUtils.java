/*    */ package cn.ubot.utils;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonProcessingException;
/*    */ import com.fasterxml.jackson.databind.JavaType;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JsonUtils
/*    */ {
/* 15 */   private static final ObjectMapper MAPPER = new ObjectMapper();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String objectToJson(Object data) {
/*    */     try {
/* 26 */       return MAPPER.writeValueAsString(data);
/*    */     }
/* 28 */     catch (JsonProcessingException e) {
/* 29 */       e.printStackTrace();
/*    */       
/* 31 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
/*    */     try {
/* 43 */       return (T)MAPPER.readValue(jsonData, beanType);
/*    */     }
/* 45 */     catch (Exception e) {
/* 46 */       e.printStackTrace();
/*    */       
/* 48 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
/* 60 */     JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, new Class[] { beanType });
/*    */     try {
/* 62 */       return (List)MAPPER.readValue(jsonData, javaType);
/*    */     }
/* 64 */     catch (Exception e) {
/* 65 */       e.printStackTrace();
/*    */ 
/*    */       
/* 68 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\commin\JsonUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */