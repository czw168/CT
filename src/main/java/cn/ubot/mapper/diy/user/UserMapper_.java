package cn.ubot.mapper.diy.user;

import cn.ubot.pojo.diy.user.RolePermission_;
import cn.ubot.pojo.diy.user.UserRole_;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper_ {
  List<UserRole_> listUserAndRole();
  
  Integer getIdByName(@Param("name") String paramString);
  
  List<String> getPermissionNameByid(@Param("id") Long paramLong);
  
  List<RolePermission_> getRoleNameAndPermissionName();
}


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\mapper\di\\user\UserMapper_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */