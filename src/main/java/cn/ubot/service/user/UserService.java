package cn.ubot.service.user;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.diy.user.UserRole_;
import cn.ubot.pojo.generator.User;

public interface UserService {
	EUDataGridResult listUser(Integer paramInteger1, Integer paramInteger2);

	AjaxResult addUser(UserRole_ paramUserRole_);

	AjaxResult updateUser(UserRole_ paramUserRole_);

	AjaxResult deleteUser(Long paramLong);

	User getUserByName(String paramString);

	AjaxResult checkUserName(String paramString);
}
