package cn.ubot.service.user;

import cn.ubot.commin.AjaxResult;
import cn.ubot.commin.EUDataGridResult;
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


/* Location:              C:\Users\victor_chen\Desktop\新建文件夹 (2)\CT\WEB-INF\classes\!\c\\ubot\servic\\user\UserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */