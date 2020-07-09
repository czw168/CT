/*    */ package cn.ubot.controller;
/*    */ 
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMethod;
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
/*    */ @Controller
/*    */ public class PageController
/*    */ {
/*    */   @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
/* 21 */   public String login() { return "login"; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @RequestMapping({"/index"})
/* 30 */   public String index() { return "index"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @RequestMapping({"/unauthorized"})
/* 35 */   public String noPerms() { return "unauthorized"; }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\controller\PageController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */