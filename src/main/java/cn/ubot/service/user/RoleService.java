package cn.ubot.service.user;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUComboBoxResult;
import cn.ubot.commin.EUDataGridResult;
import cn.ubot.pojo.diy.user.RolePermission_;
import cn.ubot.pojo.generator.Role;
import cn.ubot.pojo.generator.User;
import java.util.List;
import java.util.Set;

public interface RoleService {
  Set<String> listRoleNames(String paramString);
  
  List<Role> listRoles(String paramString);
  
  List<Role> listRoles(User paramUser);
  
  List<EUComboBoxResult> listRoleName();
  
  EUDataGridResult listRole(Integer paramInteger1, Integer paramInteger2);
  
  AjaxResult addRole(RolePermission_ paramRolePermission_);
  
  AjaxResult updateRole(RolePermission_ paramRolePermission_);
  
  AjaxResult deleteRole(String paramString);
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\servic\\user\RoleService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */