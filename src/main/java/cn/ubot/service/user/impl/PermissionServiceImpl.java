/*     */ package cn.ubot.service.user.impl;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.mapper.diy.user.UserMapper_;
/*     */ import cn.ubot.mapper.generator.PermissionMapper;
/*     */ import cn.ubot.mapper.generator.RoleMapper;
/*     */ import cn.ubot.mapper.generator.RolePermissionMapper;
/*     */ import cn.ubot.pojo.generator.Permission;
/*     */ import cn.ubot.pojo.generator.PermissionExample;
/*     */ import cn.ubot.pojo.generator.Role;
/*     */ import cn.ubot.pojo.generator.RolePermission;
/*     */ import cn.ubot.pojo.generator.RolePermissionExample;
/*     */ import cn.ubot.service.user.PermissionService;
/*     */ import cn.ubot.service.user.RoleService;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class PermissionServiceImpl
/*     */   implements PermissionService
/*     */ {
/*     */   @Autowired
/*     */   private UserMapper_ userManagerMapper;
/*     */   @Autowired
/*     */   private PermissionMapper permissionMapper;
/*     */   @Autowired
/*     */   private RoleMapper roleMapper;
/*     */   @Autowired
/*     */   private RolePermissionMapper rolePermissionMapper;
/*     */   @Autowired
/*     */   private RoleService roleService;
/*     */   
/*     */   public Set<String> listPermissions(String userName) {
/*  43 */     Set<String> result = new HashSet<String>();
/*  44 */     List<Role> roles = this.roleService.listRoles(userName);
/*     */     
/*  46 */     List<RolePermission> rolePermissions = new ArrayList<RolePermission>();
/*     */     
/*  48 */     for (Role role : roles) {
/*  49 */       RolePermissionExample example = new RolePermissionExample();
/*  50 */       example.createCriteria().andRidEqualTo(role.getId());
/*  51 */       List<RolePermission> rps = this.rolePermissionMapper.selectByExample(example);
/*  52 */       rolePermissions.addAll(rps);
/*     */     } 
/*     */     
/*  55 */     for (RolePermission rolePermission : rolePermissions) {
/*  56 */       Permission p = this.permissionMapper.selectByPrimaryKey(rolePermission.getPid());
/*  57 */       result.add(p.getName());
/*     */     } 
/*     */     
/*  60 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public EUDataGridResult listPermission(Integer page, Integer rows) {
/*  65 */     EUDataGridResult result = new EUDataGridResult();
/*  66 */     PageHelper.startPage(page.intValue(), rows.intValue());
/*  67 */     PermissionExample example = new PermissionExample();
/*  68 */     List<Permission> listPermission = this.permissionMapper.selectByExample(example);
/*  69 */     result.setRows(listPermission);
/*     */     
/*  71 */     PageInfo<Permission> pageInfo = new PageInfo<Permission>(listPermission);
/*  72 */     result.setTotal(pageInfo.getTotal());
/*  73 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult addPermission(Permission permission) {
/*     */     try {
/*  79 */       this.permissionMapper.insertSelective(permission);
/*  80 */       return AjaxResult.ok();
/*  81 */     } catch (Exception e) {
/*  82 */       e.printStackTrace();
/*  83 */       return AjaxResult.build(Integer.valueOf(500), "Duplicate permission name");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult updatePermission(Permission permission) {
/*     */     try {
/*  90 */       PermissionExample example = new PermissionExample();
/*  91 */       PermissionExample.Criteria criteria = example.createCriteria();
/*  92 */       criteria.andIdEqualTo(permission.getId());
/*  93 */       this.permissionMapper.updateByExampleSelective(permission, example);
/*  94 */       return AjaxResult.ok();
/*  95 */     } catch (Exception e) {
/*  96 */       e.printStackTrace();
/*  97 */       return AjaxResult.build(Integer.valueOf(500), "Duplicate permission name");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult deletePermission(Long id) {
/* 103 */     this.permissionMapper.deleteByPrimaryKey(id);
/* 104 */     return AjaxResult.ok();
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
/*     */   public AjaxResult listPermission() {
/* 147 */     PermissionExample example = new PermissionExample();
/* 148 */     List<Permission> listPermission = this.permissionMapper.selectByExample(example);
/*     */ 
/*     */     
/* 151 */     return AjaxResult.ok(listPermission);
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\servic\\user\impl\PermissionServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */