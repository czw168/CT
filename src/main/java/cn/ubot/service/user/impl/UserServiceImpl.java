/*     */ package cn.ubot.service.user.impl;
/*     */ 
/*     */ import cn.ubot.commin.AjaxResult;
/*     */ import cn.ubot.commin.EUDataGridResult;
/*     */ import cn.ubot.commin.ExceptionUtil;
/*     */ import cn.ubot.mapper.diy.user.UserMapper_;
/*     */ import cn.ubot.mapper.generator.UserMapper;
/*     */ import cn.ubot.mapper.generator.UserRoleMapper;
/*     */ import cn.ubot.pojo.diy.user.UserRole_;
/*     */ import cn.ubot.pojo.generator.User;
/*     */ import cn.ubot.pojo.generator.UserExample;
/*     */ import cn.ubot.pojo.generator.UserRole;
/*     */ import cn.ubot.pojo.generator.UserRoleExample;
/*     */ import cn.ubot.service.user.UserService;
/*     */ import com.github.pagehelper.PageHelper;
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import com.github.pagehelper.util.StringUtil;
/*     */ import java.sql.Date;
/*     */ import java.util.List;
/*     */ import org.apache.shiro.crypto.SecureRandomNumberGenerator;
/*     */ import org.apache.shiro.crypto.hash.SimpleHash;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class UserServiceImpl
/*     */   implements UserService
/*     */ {
/*     */   @Autowired
/*     */   private UserMapper_ userManagerMapper;
/*     */   @Autowired
/*     */   private UserMapper userMapper;
/*     */   @Autowired
/*     */   private UserRoleMapper userRoleMapper;
/*     */   
/*     */   public EUDataGridResult listUser(Integer page, Integer rows) {
/*  40 */     EUDataGridResult result = new EUDataGridResult();
/*  41 */     PageHelper.startPage(page.intValue(), rows.intValue());
/*  42 */     List<UserRole_> listUserAndRole = this.userManagerMapper.listUserAndRole();
/*  43 */     result.setRows(listUserAndRole);
/*     */     
/*  45 */     PageInfo<UserRole_> pageInfo = new PageInfo<UserRole_>(listUserAndRole);
/*  46 */     result.setTotal(pageInfo.getTotal());
/*  47 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult addUser(UserRole_ userRole_) {
/*     */     try {
/*  53 */       String name = userRole_.getUserName();
/*     */       
/*  55 */       String salt = (new SecureRandomNumberGenerator()).nextBytes().toString();
/*  56 */       int times = 2;
/*  57 */       String algorithmName = "md5";
/*  58 */       String encodedPassword = (new SimpleHash(algorithmName, userRole_.getPassword(), salt, times)).toString();
/*     */       
/*  60 */       User user = new User();
/*  61 */       user.setName(name);
/*  62 */       user.setPassword(encodedPassword);
/*  63 */       user.setSalt(salt);
/*  64 */       user.setStatus(Integer.valueOf(1));
/*  65 */       user.setCreateTime(new Date(System.currentTimeMillis()));
/*     */       
/*  67 */       this.userMapper.insert(user);
/*     */       
/*  69 */       UserRole userRole = new UserRole();
/*  70 */       Integer uid = this.userManagerMapper.getIdByName(name);
/*  71 */       userRole.setUid(Long.valueOf(uid.longValue()));
/*  72 */       userRole.setRid(Long.valueOf(userRole_.getRoleId().longValue()));
/*  73 */       this.userRoleMapper.insert(userRole);
/*     */     
/*     */     }
/*  76 */     catch (Exception e) {
/*  77 */       e.printStackTrace();
/*  78 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/*  80 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult updateUser(UserRole_ userRole_) {
/*     */     try {
/*  86 */       User user = new User();
/*  87 */       user.setId(userRole_.getId());
/*  88 */       user.setUpdateTime(new Date(System.currentTimeMillis()));
/*  89 */       user.setStatus(userRole_.getStatus());
/*  90 */       if (!StringUtil.isEmpty(userRole_.getPassword())) {
/*     */         
/*  92 */         String salt = (new SecureRandomNumberGenerator()).nextBytes().toString();
/*  93 */         int times = 2;
/*  94 */         String algorithmName = "md5";
/*  95 */         String encodedPassword = (new SimpleHash(algorithmName, userRole_.getPassword(), salt, times)).toString();
/*  96 */         user.setPassword(encodedPassword);
/*  97 */         user.setSalt(salt);
/*     */       } 
/*  99 */       this.userMapper.updateByPrimaryKeySelective(user);
/*     */       
/* 101 */       UserRole userRole = new UserRole();
/* 102 */       userRole.setUid(userRole_.getId());
/* 103 */       userRole.setRid(Long.valueOf(userRole_.getRoleId().longValue()));
/* 104 */       UserRoleExample example = new UserRoleExample();
/* 105 */       UserRoleExample.Criteria criteria = example.createCriteria();
/* 106 */       criteria.andUidEqualTo(userRole_.getId());
/* 107 */       this.userRoleMapper.updateByExampleSelective(userRole, example);
/* 108 */     } catch (Exception e) {
/* 109 */       e.printStackTrace();
/* 110 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/* 112 */     return AjaxResult.ok();
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult deleteUser(Long id) {
/*     */     try {
/* 118 */       this.userMapper.deleteByPrimaryKey(id);
/* 119 */       UserRoleExample example = new UserRoleExample();
/* 120 */       UserRoleExample.Criteria criteria = example.createCriteria();
/* 121 */       criteria.andUidEqualTo(id);
/* 122 */       this.userRoleMapper.deleteByExample(example);
/* 123 */       return AjaxResult.ok();
/* 124 */     } catch (Exception e) {
/* 125 */       e.printStackTrace();
/* 126 */       return AjaxResult.build(Integer.valueOf(500), ExceptionUtil.getStackTrace(e));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public User getUserByName(String name) {
/* 132 */     UserExample example = new UserExample();
/* 133 */     UserExample.Criteria criteria = example.createCriteria();
/* 134 */     criteria.andNameEqualTo(name);
/* 135 */     List<User> UserList = this.userMapper.selectByExample(example);
/* 136 */     if (UserList.isEmpty()) {
/* 137 */       return null;
/*     */     }
/* 139 */     return (User)UserList.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public AjaxResult checkUserName(String name) {
/* 144 */     UserExample example = new UserExample();
/* 145 */     UserExample.Criteria criteria = example.createCriteria();
/* 146 */     criteria.andNameEqualTo(name);
/* 147 */     List<User> UserList = this.userMapper.selectByExample(example);
/*     */     
/* 149 */     if (UserList.isEmpty()) {
/* 150 */       return AjaxResult.ok();
/*     */     }
/* 152 */     return AjaxResult.ok(((User)UserList.get(0)).getName());
/*     */   }
/*     */ }


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\servic\\user\impl\UserServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */