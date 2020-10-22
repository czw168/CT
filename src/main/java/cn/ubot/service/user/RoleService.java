package cn.ubot.service.user;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
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
