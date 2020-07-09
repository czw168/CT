/*     */ package cn.ubot.commin;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NumberParser
/*     */ {
/*     */   public String convertISO8859_1ToGBK(String str) {
/*  12 */     String returnStr = "";
/*  13 */     if (str.startsWith("\"")) {
/*  14 */       str = str.substring(1);
/*     */     }
/*  16 */     if (str.endsWith("\"")) {
/*  17 */       str = str.substring(0, str.length() - 1);
/*     */     }
/*     */     try {
/*  20 */       returnStr = new String(str.getBytes("ISO8859_1"), "GBK");
/*  21 */     } catch (UnsupportedEncodingException e) {
/*  22 */       e.printStackTrace();
/*     */     } 
/*  24 */     return returnStr;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  30 */       String str = "中山廠區: 台中市潭子區中山路三段153號";
/*  31 */       String str1 = new String(str.getBytes("GBK"), "iso8859-1");
/*  32 */       System.out.println(str1);
/*     */       
/*  34 */       System.out.println(new String(str1.getBytes("iso8859-1"), "GBK"));
/*     */     }
/*  36 */     catch (UnsupportedEncodingException e) {
/*  37 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  42 */   private static final String[] SINGLE_NUM_ARR = { "", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
/*     */   
/*  44 */   private static final String[] TEN_NUM_ARR = { "TEN", "ELEVEN", "TWELEVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
/*     */   
/*  46 */   private static final String[] TEN_INTEGER_ARR = { "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY" };
/*     */   
/*     */   public static String parse(String x) {
/*  49 */     if (Double.parseDouble(x) <= 0.0D) {
/*  50 */       return "ZERO CENTS ONLY";
/*     */     }
/*  52 */     int z = x.indexOf(".");
/*  53 */     String lstr = "", rstr = "";
/*  54 */     if (z > -1) {
/*  55 */       lstr = x.substring(0, z);
/*  56 */       rstr = x.substring(z + 1);
/*     */     } else {
/*  58 */       lstr = x;
/*     */     } 
/*  60 */     String lstrrev = reverse(lstr);
/*  61 */     String[] a = new String[5];
/*     */     
/*  63 */     switch (lstrrev.length() % 3) {
/*     */       case 1:
/*  65 */         lstrrev = lstrrev + "00";
/*     */         break;
/*     */       case 2:
/*  68 */         lstrrev = lstrrev + "0";
/*     */         break;
/*     */     } 
/*  71 */     String lm = "";
/*  72 */     for (int i = 0; i < lstrrev.length() / 3; i++) {
/*  73 */       a[i] = reverse(lstrrev.substring(3 * i, 3 * i + 3));
/*  74 */       if (!a[i].equals("000"))
/*  75 */       { if (i != 0) {
/*  76 */           lm = transThree(a[i]) + " " + parseMore(String.valueOf(i)) + " " + lm;
/*     */         } else {
/*     */           
/*  79 */           lm = transThree(a[i]);
/*     */         }  }
/*  81 */       else { lm = lm + transThree(a[i]); }
/*     */     
/*     */     } 
/*  84 */     String xs = "";
/*  85 */     if (z > -1) {
/*  86 */       String transTwo = transTwo(rstr);
/*  87 */       if (transTwo == null || "".equals(transTwo)) {
/*  88 */         xs = "";
/*     */       } else {
/*  90 */         xs = "AND " + transTwo + " CENTS ";
/*     */       } 
/*     */     } 
/*  93 */     return lm.trim() + " " + xs + "ONLY";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  98 */   private static String parseFirst(String s) { return SINGLE_NUM_ARR[Integer.parseInt(s.substring(s.length() - 1))]; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   private static String parseTeen(String s) { return TEN_NUM_ARR[Integer.parseInt(s) - 10]; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   private static String parseTen(String s) { return TEN_INTEGER_ARR[Integer.parseInt(s.substring(0, 1)) - 1]; }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String transTwo(String s) {
/* 113 */     String value = "";
/*     */     
/* 115 */     if (s.length() > 2) {
/* 116 */       s = s.substring(0, 2);
/* 117 */     } else if (s.length() < 2) {
/* 118 */       s = s + "0";
/*     */     } 
/* 120 */     if (s.startsWith("0")) {
/* 121 */       value = parseFirst(s);
/* 122 */     } else if (s.startsWith("1")) {
/* 123 */       value = parseTeen(s);
/* 124 */     } else if (s.endsWith("0")) {
/* 125 */       value = parseTen(s);
/*     */     } else {
/* 127 */       value = parseTen(s) + " " + parseFirst(s);
/* 128 */     }  return value;
/*     */   }
/*     */   
/*     */   private static String parseMore(String s) {
/* 132 */     String[] a = { "", "THOUSAND", "MILLION", "BILLION" };
/* 133 */     return a[Integer.parseInt(s)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String transThree(String s) {
/* 139 */     String value = "";
/* 140 */     if (s.startsWith("0")) {
/* 141 */       value = transTwo(s.substring(1));
/* 142 */     } else if (s.substring(1).equals("00")) {
/* 143 */       value = parseFirst(s.substring(0, 1)) + " HUNDRED";
/*     */     } else {
/* 145 */       value = parseFirst(s.substring(0, 1)) + " HUNDRED AND " + transTwo(s.substring(1));
/* 146 */     }  return value;
/*     */   }
/*     */   
/*     */   private static String reverse(String s) {
/* 150 */     char[] aChr = s.toCharArray();
/* 151 */     StringBuffer tmp = new StringBuffer();
/* 152 */     for (int i = aChr.length - 1; i >= 0; i--) {
/* 153 */       tmp.append(aChr[i]);
/*     */     }
/* 155 */     return tmp.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\commin\NumberParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */