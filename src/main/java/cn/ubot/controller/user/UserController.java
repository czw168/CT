/*     */ package cn.ubot.controller.user;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUComboBoxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.JsonUtils;
/*     */ import cn.ubot.pojo.diy.user.RolePermission_;
/*     */ import cn.ubot.pojo.diy.user.UserRole_;
/*     */ import cn.ubot.pojo.generator.Permission;
/*     */ import cn.ubot.service.user.PermissionService;
/*     */ import cn.ubot.service.user.RoleService;
/*     */ import cn.ubot.service.user.UserService;
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import java.util.List;
/*     */ import org.apache.shiro.authz.annotation.RequiresRoles;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
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
/*     */ @Controller
/*     */ @RequestMapping({"/user"})
/*     */ public class UserController
/*     */ {
/*     */   @Autowired
/*     */   private UserService userService;
/*     */   @Autowired
/*     */   private RoleService roleService;
/*     */   @Autowired
/*     */   private PermissionService permissionService;
/*     */   
/*     */   @RequiresRoles({"admin"})
/*     */   @RequestMapping({"/{page}"})
/*  50 */   public String showPage(@PathVariable String page) { return "/user/" + page; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listUser"})
/*     */   @ResponseBody
/*  62 */   EUDataGridResult listUser(Integer page, Integer rows) { return this.userService.listUser(page, rows); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addUser"})
/*     */   @ResponseBody
/*     */   AjaxResult addUser(@RequestBody JSONObject obj) {
/*  73 */     UserRole_ userRole_ = (UserRole_)JsonUtils.jsonToPojo(obj.toJSONString(), UserRole_.class);
/*  74 */     return this.userService.addUser(userRole_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/updateUser"})
/*     */   @ResponseBody
/*     */   AjaxResult updateUser(@RequestBody JSONObject obj) {
/*  85 */     UserRole_ userRole_ = (UserRole_)JsonUtils.jsonToPojo(obj.toJSONString(), UserRole_.class);
/*  86 */     return this.userService.updateUser(userRole_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/deleteUser"})
/*     */   @ResponseBody
/*     */   AjaxResult deleteUser(@RequestBody JSONObject obj) {
/*  97 */     Long id = obj.getLong("id");
/*  98 */     return this.userService.deleteUser(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/checkUserName"})
/*     */   @ResponseBody
/*     */   AjaxResult checkUserName(@RequestBody JSONObject obj) {
/* 109 */     String name = obj.getString("name");
/* 110 */     return this.userService.checkUserName(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/listRoleName"})
/*     */   @ResponseBody
/* 122 */   List<EUComboBoxResult> listRoleName() { return this.roleService.listRoleName(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listRole"})
/*     */   @ResponseBody
/* 134 */   EUDataGridResult listRole(Integer page, Integer rows) { return this.roleService.listRole(page, rows); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addRole"})
/*     */   @ResponseBody
/*     */   AjaxResult addRoleAndPermission(@RequestBody JSONObject obj) {
/* 145 */     String roleName = obj.getString("roleName");
/* 146 */     String roleDesc = obj.getString("roleDesc");
/* 147 */     JSONArray jsonArray = obj.getJSONArray("permissionNameList");
/* 148 */     List<String> permissionNameList = jsonArray.toJavaList(String.class);
/* 149 */     RolePermission_ rolePermission_ = new RolePermission_();
/* 150 */     rolePermission_.setRoleName(roleName);
/* 151 */     rolePermission_.setRoleDesc(roleDesc);
/* 152 */     rolePermission_.setPermissionNameList(permissionNameList);
/*     */     
/* 154 */     return this.roleService.addRole(rolePermission_);
/*     */   }
/*     */   
/*     */   @PostMapping({"/updateRole"})
/*     */   @ResponseBody
/*     */   AjaxResult updateRole(@RequestBody JSONObject obj) {
/* 160 */     String id = obj.getString("id");
/* 161 */     String roleDesc = obj.getString("roleDesc");
/* 162 */     JSONArray jsonArray = obj.getJSONArray("permissionNameList");
/* 163 */     List<String> permissionNameList = jsonArray.toJavaList(String.class);
/* 164 */     RolePermission_ rolePermission_ = new RolePermission_();
/* 165 */     rolePermission_.setId(Long.valueOf(Long.parseLong(id)));
/* 166 */     rolePermission_.setRoleDesc(roleDesc);
/* 167 */     rolePermission_.setPermissionNameList(permissionNameList);
/* 168 */     return this.roleService.updateRole(rolePermission_);
/*     */   }
/*     */   
/*     */   @PostMapping({"/deleteRole"})
/*     */   @ResponseBody
/*     */   AjaxResult deleteRole(@RequestBody JSONObject obj) {
/* 174 */     String id = obj.getString("id");
/* 175 */     return this.roleService.deleteRole(id);
/*     */   }
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
/*     */   @GetMapping({"/listPermission"})
/*     */   @ResponseBody
/* 189 */   EUDataGridResult listPermission(Integer page, Integer rows) { return this.permissionService.listPermission(page, rows); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/addPermission"})
/*     */   @ResponseBody
/*     */   AjaxResult addPermission(@RequestBody JSONObject obj) {
/* 200 */     Permission permission = (Permission)JsonUtils.jsonToPojo(obj.toJSONString(), Permission.class);
/* 201 */     return this.permissionService.addPermission(permission);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/updatePermission"})
/*     */   @ResponseBody
/*     */   AjaxResult updatePermission(@RequestBody JSONObject obj) {
/* 212 */     Permission permission = (Permission)JsonUtils.jsonToPojo(obj.toJSONString(), Permission.class);
/* 213 */     return this.permissionService.updatePermission(permission);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/deletePermission"})
/*     */   @ResponseBody
/*     */   AjaxResult deletePermission(@RequestBody JSONObject obj) {
/* 224 */     Long id = obj.getLong("id");
/* 225 */     return this.permissionService.deletePermission(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @GetMapping({"/listPermission_"})
/*     */   @ResponseBody
/* 235 */   AjaxResult listPermission() { return this.permissionService.listPermission(); }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\controlle\\user\UserController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */