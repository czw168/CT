/*     */ package cn.ubot.service.user.impl;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUComboBoxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.ExceptionUtil;
/*     */ import cn.ubot.mapper.diy.user.UserMapper_;
/*     */ import cn.ubot.mapper.generator.RoleMapper;
/*     */ import cn.ubot.mapper.generator.RolePermissionMapper;
/*     */ import cn.ubot.mapper.generator.UserRoleMapper;
/*     */ import cn.ubot.pojo.diy.user.RolePermission_;
/*     */ import cn.ubot.pojo.generator.Role;
/*     */ import cn.ubot.pojo.generator.RoleExample;
/*     */ import cn.ubot.pojo.generator.RolePermission;
/*     */ import cn.ubot.pojo.generator.RolePermissionExample;
/*     */ import cn.ubot.pojo.generator.User;
/*     */ import cn.ubot.pojo.generator.UserRole;
/*     */ import cn.ubot.pojo.generator.UserRoleExample;
/*     */ import cn.ubot.service.user.RoleService;
/*     */ import cn.ubot.service.user.UserService;
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
/*     */ 
/*     */ @Service
/*     */ public class RoleServiceImpl
/*     */   implements RoleService
/*     */ {
/*     */   @Autowired
/*     */   private UserMapper_ userManagerMapper;
/*     */   @Autowired
/*     */   private RoleMapper roleMapper;
/*     */   @Autowired
/*     */   private RolePermissionMapper rolePermissionMapper;
/*     */   @Autowired
/*     */   private UserRoleMapper userRoleMapper;
/*     */   @Autowired
/*     */   private UserService userService;
/*     */   
/*     */   public Set<String> listRoleNames(String userName) {
/*  48 */     Set<String> result = new HashSet<String>();
/*  49 */     List<Role> roles = listRoles(userName);
/*  50 */     for (Role role : roles) {
/*  51 */       result.add(role.getName());
/*     */     }
/*  53 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Role> listRoles(String userName) {
/*  58 */     List<Role> roles = new ArrayList<Role>();
/*  59 */     User user = this.userService.getUserByName(userName);
/*  60 */     if (null == user) {
/*  61 */       return roles;
/*     */     }
/*  63 */     return listRoles(user);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Role> listRoles(User user) {
/*  69 */     List<Role> roles = new ArrayList<Role>();
/*     */     
/*  71 */     UserRoleExample example = new UserRoleExample();
/*     */     
/*  73 */     example.createCriteria().andUidEqualTo(user.getId());
/*  74 */     List<UserRole> userRoles = this.userRoleMapper.selectByExample(example);
/*     */     
/*  76 */     for (UserRole userRole : userRoles) {
/*  77 */       Role role = this.roleMapper.selectByPrimaryKey(userRole.getRid());
/*  78 */       roles.add(role);
/*     */     } 
/*  80 */     return roles;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<EUComboBoxResult> listRoleName() {
/*  85 */     List<EUComboBoxResult> l = new ArrayList<EUComboBoxResult>();
/*  86 */     RoleExample example = new RoleExample();
/*  87 */     List<Role> RoleList = this.roleMapper.selectByExample(example);
/*  88 */     for (Role role : RoleList) {
/*  89 */       EUComboBoxResult eur2 = new EUComboBoxResult(role.getId() + "", role.getName(), null);
/*  90 */       l.add(eur2);
/*     */     } 
/*  92 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public EUDataGridResult listRole(Integer page, Integer rows) {
/*  97 */     EUDataGridResult result = new EUDataGridResult();
/*     */     
/*  99 */     RoleExample roleExample = new RoleExample();
/* 100 */     List<Role> roleList = this.roleMapper.selectByExample(roleExample);
/*     */     
/* 102 */     List<RolePermission_> rolePermissionList = new ArrayList<RolePermission_>();
/* 103 */     for (Role role : roleList) {
/* 104 */       RolePermission_ rp = new RolePermission_();
/* 105 */       rp.setId(role.getId());
/* 106 */       rp.setRoleDesc(role.getDesc());
/* 107 */       rp.setRoleName(role.getName());
/*     */       
/* 109 */       List<String> permissionNameList = this.userManagerMapper.getPermissionNameByid(Long.valueOf(role.getId().longValue()));
/* 110 */       rp.setPermissionNameList(permissionNameList);
/* 111 */       rolePermissionList.add(rp);
/*     */     } 
/* 113 */     result.setRows(rolePermissionList);
/*     */     
/* 115 */     PageInfo<RolePermission_> pageInfo = new PageInfo<RolePermission_>(rolePermissionList);
/* 116 */     result.setTotal(pageInfo.getTotal());
/*     */     
/* 118 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult addRole(RolePermission_ rolePermission_) {
/*     */     try {
/* 124 */       Role role = new Role();
/* 125 */       role.setName(rolePermission_.getRoleName());
/* 126 */       role.setDesc(rolePermission_.getRoleDesc());
/* 127 */       this.roleMapper.insertSelective(role);
/*     */       
/* 129 */       List<String> permissionNameList = rolePermission_.getPermissionNameList();
/* 130 */       for (String permissionName : permissionNameList) {
/*     */         
/* 132 */         RoleExample example = new RoleExample();
/* 133 */         RoleExample.Criteria criteria = example.createCriteria();
/* 134 */         criteria.andNameEqualTo(rolePermission_.getRoleName());
/* 135 */         List<Role> roleList = this.roleMapper.selectByExample(example);
/* 136 */         Long rid = ((Role)roleList.get(0)).getId();
/* 137 */         Long pid = Long.valueOf(Long.parseLong(permissionName));
/* 138 */         RolePermission rolePermission = new RolePermission();
/* 139 */         rolePermission.setRid(rid);
/* 140 */         rolePermission.setPid(pid);
/* 141 */         this.rolePermissionMapper.insertSelective(rolePermission);
/*     */       } 
/* 143 */     } catch (NumberFormatException e) {
/* 144 */       e.printStackTrace();
/* 145 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 147 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AjaxResult updateRole(RolePermission_ rolePermission_) {
/* 153 */     Role role = new Role();
/* 154 */     role.setId(rolePermission_.getId());
/* 155 */     role.setDesc(rolePermission_.getRoleDesc());
/*     */ 
/*     */     
/*     */     try {
/* 159 */       RolePermissionExample example = new RolePermissionExample();
/* 160 */       RolePermissionExample.Criteria criteria = example.createCriteria();
/* 161 */       criteria.andRidEqualTo(role.getId());
/* 162 */       this.rolePermissionMapper.deleteByExample(example);
/*     */       
/* 164 */       List<String> permissionNameList = rolePermission_.getPermissionNameList();
/* 165 */       for (int i = 0; i < permissionNameList.size(); i++) {
/* 166 */         RolePermission rp = new RolePermission();
/* 167 */         rp.setRid(role.getId());
/* 168 */         rp.setPid(Long.valueOf(Long.parseLong((String)permissionNameList.get(i))));
/* 169 */         this.rolePermissionMapper.insert(rp);
/*     */       } 
/* 171 */     } catch (NumberFormatException e) {
/* 172 */       e.printStackTrace();
/* 173 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 175 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult deleteRole(String id) {
/* 180 */     this.roleMapper.deleteByPrimaryKey(Long.valueOf(Long.parseLong(id)));
/* 181 */     RolePermissionExample example = new RolePermissionExample();
/* 182 */     RolePermissionExample.Criteria criteria = example.createCriteria();
/* 183 */     criteria.andRidEqualTo(Long.valueOf(Long.parseLong(id)));
/* 184 */     this.rolePermissionMapper.deleteByExample(example);
/* 185 */     return AjaxResult.ok();
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\servic\\user\impl\RoleServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */