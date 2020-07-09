/*    */ package cn.ubot.exception;
/*    */ 
/*    */ import org.apache.shiro.authz.UnauthorizedException;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.web.bind.annotation.ControllerAdvice;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.ResponseStatus;
/*    */ import org.springframework.web.context.request.NativeWebRequest;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ @ControllerAdvice
/*    */ public class DefaultExceptionHandler {
/*    */   @ExceptionHandler({UnauthorizedException.class})
/*    */   @ResponseStatus(HttpStatus.UNAUTHORIZED)
/*    */   public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
/* 16 */     ModelAndView mv = new ModelAndView();
/* 17 */     mv.addObject("ex", e);
/* 18 */     mv.setViewName("unauthorized");
/* 19 */     return mv;
/*    */   }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\exception\DefaultExceptionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */