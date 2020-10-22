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
