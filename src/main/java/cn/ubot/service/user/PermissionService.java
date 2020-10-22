package cn.ubot.service.user;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.generator.Permission;
import java.util.Set;

public interface PermissionService {
	Set<String> listPermissions(String paramString);

	EUDataGridResult listPermission(Integer paramInteger1, Integer paramInteger2);

	AjaxResult addPermission(Permission paramPermission);

	AjaxResult updatePermission(Permission paramPermission);

	AjaxResult deletePermission(Long paramLong);

	AjaxResult listPermission();
}
