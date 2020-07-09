package cn.ubot.service.user;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridResult;
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


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\servic\\user\PermissionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */