/*    */ package cn.ubot.controller;
/*    */ 
/*    */ import cn.ubot.commin.AjaxResult;
/*    */ import org.apache.shiro.SecurityUtils;
/*    */ import org.apache.shiro.authc.AuthenticationException;
/*    */ import org.apache.shiro.authc.LockedAccountException;
/*    */ import org.apache.shiro.authc.UsernamePasswordToken;
/*    */ import org.apache.shiro.session.Session;
/*    */ import org.apache.shiro.subject.Subject;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMethod;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class LoginController
/*    */ {
/*    */   @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public AjaxResult login(Model model, String name, String password) {
/* 23 */     Subject subject = SecurityUtils.getSubject();
/* 24 */     UsernamePasswordToken token = new UsernamePasswordToken(name, password);
/*    */     try {
/* 26 */       subject.login(token);
/* 27 */       Session session = subject.getSession();
/* 28 */       session.setAttribute("subject", subject);
/* 29 */       return AjaxResult.ok();
/* 30 */     } catch (LockedAccountException lae) {
/* 31 */       return AjaxResult.build(Integer.valueOf(400), "The user is locked");
/* 32 */     } catch (AuthenticationException e) {
/* 33 */       e.printStackTrace();
/* 34 */       return AjaxResult.build(Integer.valueOf(400), "Authentication failed");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\controller\LoginController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */