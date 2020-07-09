/*    */ package cn.ubot.realm;
/*    */ 
/*    */ import cn.ubot.pojo.generator.User;
/*    */ import cn.ubot.service.user.PermissionService;
/*    */ import cn.ubot.service.user.RoleService;
/*    */ import cn.ubot.service.user.UserService;
/*    */ import java.util.Set;
/*    */ import org.apache.shiro.authc.AuthenticationException;
/*    */ import org.apache.shiro.authc.AuthenticationInfo;
/*    */ import org.apache.shiro.authc.AuthenticationToken;
/*    */ import org.apache.shiro.authc.LockedAccountException;
/*    */ import org.apache.shiro.authc.SimpleAuthenticationInfo;
/*    */ import org.apache.shiro.authz.AuthorizationInfo;
/*    */ import org.apache.shiro.authz.SimpleAuthorizationInfo;
/*    */ import org.apache.shiro.realm.AuthorizingRealm;
/*    */ import org.apache.shiro.subject.PrincipalCollection;
/*    */ import org.apache.shiro.util.ByteSource;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DatabaseRealm
/*    */   extends AuthorizingRealm
/*    */ {
/*    */   @Autowired
/*    */   private UserService userService;
/*    */   @Autowired
/*    */   private RoleService roleService;
/*    */   @Autowired
/*    */   private PermissionService permissionService;
/*    */   
/*    */   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
/* 37 */     String userName = (String)principalCollection.getPrimaryPrincipal();
/*    */     
/* 39 */     Set<String> permissions = this.permissionService.listPermissions(userName);
/* 40 */     Set<String> roles = this.roleService.listRoleNames(userName);
/*    */ 
/*    */     
/* 43 */     SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
/*    */     
/* 45 */     s.setStringPermissions(permissions);
/* 46 */     s.setRoles(roles);
/* 47 */     return s;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
/* 54 */     String userName = token.getPrincipal().toString();
/*    */     
/* 56 */     User user = this.userService.getUserByName(userName);
/* 57 */     if (user.getStatus().intValue() == 0) {
/* 58 */       throw new LockedAccountException();
/*    */     }
/* 60 */     String passwordInDB = user.getPassword();
/* 61 */     String salt = user.getSalt();
/*    */ 
/*    */ 
/*    */     
/* 65 */     return new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
/*    */   }
/*    */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\realm\DatabaseRealm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */