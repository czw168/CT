/*     */ package cn.ubot.commin;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.net.URLEncoder;
/*     */ import javax.servlet.http.Cookie;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
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
/*     */ public final class CookieUtils
/*     */ {
/*  26 */   public static String getCookieValue(HttpServletRequest request, String cookieName) { return getCookieValue(request, cookieName, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
/*  37 */     Cookie[] cookieList = request.getCookies();
/*  38 */     if (cookieList == null || cookieName == null) {
/*  39 */       return null;
/*     */     }
/*  41 */     String retValue = null;
/*     */     try {
/*  43 */       for (int i = 0; i < cookieList.length; i++) {
/*  44 */         if (cookieList[i].getName().equals(cookieName)) {
/*  45 */           if (isDecoder) {
/*  46 */             retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8"); break;
/*     */           } 
/*  48 */           retValue = cookieList[i].getValue();
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  53 */     } catch (UnsupportedEncodingException e) {
/*  54 */       e.printStackTrace();
/*     */     } 
/*  56 */     return retValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
/*  67 */     Cookie[] cookieList = request.getCookies();
/*  68 */     if (cookieList == null || cookieName == null) {
/*  69 */       return null;
/*     */     }
/*  71 */     String retValue = null;
/*     */     try {
/*  73 */       for (int i = 0; i < cookieList.length; i++) {
/*  74 */         if (cookieList[i].getName().equals(cookieName)) {
/*  75 */           retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
/*     */           break;
/*     */         } 
/*     */       } 
/*  79 */     } catch (UnsupportedEncodingException e) {
/*  80 */       e.printStackTrace();
/*     */     } 
/*  82 */     return retValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue) { setCookie(request, response, cookieName, cookieValue, -1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage) { setCookie(request, response, cookieName, cookieValue, cookieMaxage, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, boolean isEncode) { setCookie(request, response, cookieName, cookieValue, -1, isEncode); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) { doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, String encodeString) { doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) { doSetCookie(request, response, cookieName, "", -1, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
/*     */     try {
/* 141 */       if (cookieValue == null) {
/* 142 */         cookieValue = "";
/* 143 */       } else if (isEncode) {
/* 144 */         cookieValue = URLEncoder.encode(cookieValue, "utf-8");
/*     */       } 
/* 146 */       Cookie cookie = new Cookie(cookieName, cookieValue);
/* 147 */       if (cookieMaxage > 0)
/* 148 */         cookie.setMaxAge(cookieMaxage); 
/* 149 */       if (null != request) {
/* 150 */         String domainName = getDomainName(request);
/* 151 */         System.out.println(domainName);
/* 152 */         if (!"localhost".equals(domainName)) {
/* 153 */           cookie.setDomain(domainName);
/*     */         }
/*     */       } 
/* 156 */       cookie.setPath("/");
/* 157 */       response.addCookie(cookie);
/* 158 */     } catch (Exception e) {
/* 159 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
/*     */     try {
/* 171 */       if (cookieValue == null) {
/* 172 */         cookieValue = "";
/*     */       } else {
/* 174 */         cookieValue = URLEncoder.encode(cookieValue, encodeString);
/*     */       } 
/* 176 */       Cookie cookie = new Cookie(cookieName, cookieValue);
/* 177 */       if (cookieMaxage > 0)
/* 178 */         cookie.setMaxAge(cookieMaxage); 
/* 179 */       if (null != request) {
/* 180 */         String domainName = getDomainName(request);
/* 181 */         System.out.println(domainName);
/* 182 */         if (!"localhost".equals(domainName)) {
/* 183 */           cookie.setDomain(domainName);
/*     */         }
/*     */       } 
/* 186 */       cookie.setPath("/");
/* 187 */       response.addCookie(cookie);
/* 188 */     } catch (Exception e) {
/* 189 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String getDomainName(HttpServletRequest request) {
/* 197 */     String domainName = null;
/*     */     
/* 199 */     String serverName = request.getRequestURL().toString();
/* 200 */     if (serverName == null || serverName.equals("")) {
/* 201 */       domainName = "";
/*     */     } else {
/* 203 */       serverName = serverName.toLowerCase();
/* 204 */       serverName = serverName.substring(7);
/* 205 */       int end = serverName.indexOf("/");
/* 206 */       serverName = serverName.substring(0, end);
/* 207 */       String[] domains = serverName.split("\\.");
/* 208 */       int len = domains.length;
/* 209 */       if (len > 3) {
/*     */         
/* 211 */         domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
/* 212 */       } else if (len <= 3 && len > 1) {
/*     */         
/* 214 */         domainName = "." + domains[len - 2] + "." + domains[len - 1];
/*     */       } else {
/* 216 */         domainName = serverName;
/*     */       } 
/*     */     } 
/*     */     
/* 220 */     if (domainName != null && domainName.indexOf(":") > 0) {
/* 221 */       String[] ary = domainName.split("\\:");
/* 222 */       domainName = ary[0];
/*     */     } 
/* 224 */     return domainName;
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\commin\CookieUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */