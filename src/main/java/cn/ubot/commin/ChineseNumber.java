/*     */ package cn.ubot.commin;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChineseNumber
/*     */ {
/*   9 */   private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String[] CN_UPPER_MONETRAY_UNIT = { 
/*  14 */       "分", "角", "圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CN_FULL = "整";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CN_NEGATIVE = "负";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MONEY_PRECISION = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CN_ZEOR_FULL = "零元整";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
/*  42 */     StringBuffer sb = new StringBuffer();
/*     */ 
/*     */     
/*  45 */     int signum = numberOfMoney.signum();
/*     */     
/*  47 */     if (signum == 0) {
/*  48 */       return "零元整";
/*     */     }
/*     */ 
/*     */     
/*  52 */     long number = numberOfMoney.movePointRight(2).setScale(0, 4).abs().longValue();
/*     */     
/*  54 */     long scale = number % 100L;
/*  55 */     int numUnit = 0;
/*  56 */     int numIndex = 0;
/*  57 */     boolean getZero = false;
/*     */     
/*  59 */     if (scale <= 0L) {
/*  60 */       numIndex = 2;
/*  61 */       number /= 100L;
/*  62 */       getZero = true;
/*     */     } 
/*  64 */     if (scale > 0L && scale % 10L <= 0L) {
/*  65 */       numIndex = 1;
/*  66 */       number /= 10L;
/*  67 */       getZero = true;
/*     */     } 
/*  69 */     int zeroSize = 0;
/*     */     
/*  71 */     while (number > 0L) {
/*     */ 
/*     */ 
/*     */       
/*  75 */       numUnit = (int)(number % 10L);
/*  76 */       if (numUnit > 0) {
/*  77 */         if (numIndex == 9 && zeroSize >= 3) {
/*  78 */           sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
/*     */         }
/*  80 */         if (numIndex == 13 && zeroSize >= 3) {
/*  81 */           sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
/*     */         }
/*  83 */         sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
/*  84 */         sb.insert(0, CN_UPPER_NUMBER[numUnit]);
/*  85 */         getZero = false;
/*  86 */         zeroSize = 0;
/*     */       } else {
/*  88 */         zeroSize++;
/*  89 */         if (!getZero) {
/*  90 */           sb.insert(0, CN_UPPER_NUMBER[numUnit]);
/*     */         }
/*  92 */         if (numIndex == 2) {
/*  93 */           if (number > 0L) {
/*  94 */             sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
/*     */           }
/*  96 */         } else if ((numIndex - 2) % 4 == 0 && number % 1000L > 0L) {
/*  97 */           sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
/*     */         } 
/*  99 */         getZero = true;
/*     */       } 
/*     */       
/* 102 */       number /= 10L;
/* 103 */       numIndex++;
/*     */     } 
/*     */     
/* 106 */     if (signum == -1) {
/* 107 */       sb.insert(0, "负");
/*     */     }
/*     */     
/* 110 */     if (scale <= 0L) {
/* 111 */       sb.append("整");
/*     */     }
/* 113 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 117 */     double money = 103000.0D;
/* 118 */     BigDecimal numberOfMoney = new BigDecimal(money);
/* 119 */     String s = number2CNMontrayUnit(numberOfMoney);
/* 120 */     System.out.println("你输入的金额为：【" + money + "】   #--# [" + s.toString() + "]");
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\commin\ChineseNumber.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */