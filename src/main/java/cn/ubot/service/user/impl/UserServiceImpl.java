package cn.ubot.service.user.impl;

import java.sql.Date;
import java.util.List;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.user.UserMapper_;
import cn.ubot.mapper.generator.UserMapper;
import cn.ubot.mapper.generator.UserRoleMapper;
import cn.ubot.pojo.diy.user.UserRole_;
import cn.ubot.pojo.generator.User;
import cn.ubot.pojo.generator.UserExample;
import cn.ubot.pojo.generator.UserRole;
import cn.ubot.pojo.generator.UserRoleExample;
import cn.ubot.service.user.UserService;
import cn.ubot.utils.ExceptionUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper_ userManagerMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	public EUDataGridResult listUser(Integer page, Integer rows) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		List<UserRole_> listUserAndRole = this.userManagerMapper.listUserAndRole();
		result.setRows(listUserAndRole);
		PageInfo<UserRole_> pageInfo = new PageInfo<UserRole_>(listUserAndRole);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addUser(UserRole_ userRole_) {
		try {
			String name = userRole_.getUserName();
			String salt = (new SecureRandomNumberGenerator()).nextBytes().toString();
			int times = 2;
			String algorithmName = "md5";
			String encodedPassword = (new SimpleHash(algorithmName, userRole_.getPassword(), salt, times)).toString();
			User user = new User();
			user.setName(name);
			user.setPassword(encodedPassword);
			user.setSalt(salt);
			user.setStatus(Integer.valueOf(1));
			user.setCreateTime(new Date(System.currentTimeMillis()));
			this.userMapper.insert(user);
			UserRole userRole = new UserRole();
			Integer uid = this.userManagerMapper.getIdByName(name);
			userRole.setUid(Long.valueOf(uid.longValue()));
			userRole.setRid(Long.valueOf(userRole_.getRoleId().longValue()));
			this.userRoleMapper.insert(userRole);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateUser(UserRole_ userRole_) {
		try {
			User user = new User();
			user.setId(userRole_.getId());
			user.setUpdateTime(new Date(System.currentTimeMillis()));
			user.setStatus(userRole_.getStatus());
			if (!StringUtil.isEmpty(userRole_.getPassword())) {
				String salt = (new SecureRandomNumberGenerator()).nextBytes().toString();
				int times = 2;
				String algorithmName = "md5";
				String encodedPassword = (new SimpleHash(algorithmName, userRole_.getPassword(), salt, times))
						.toString();
				user.setPassword(encodedPassword);
				user.setSalt(salt);
			}
			this.userMapper.updateByPrimaryKeySelective(user);
			UserRole userRole = new UserRole();
			userRole.setUid(userRole_.getId());
			userRole.setRid(Long.valueOf(userRole_.getRoleId().longValue()));
			UserRoleExample example = new UserRoleExample();
			UserRoleExample.Criteria criteria = example.createCriteria();
			criteria.andUidEqualTo(userRole_.getId());
			this.userRoleMapper.updateByExampleSelective(userRole, example);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult deleteUser(Long id) {
		try {
			this.userMapper.deleteByPrimaryKey(id);
			UserRoleExample example = new UserRoleExample();
			UserRoleExample.Criteria criteria = example.createCriteria();
			criteria.andUidEqualTo(id);
			this.userRoleMapper.deleteByExample(example);
			return AjaxResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
	}

	public User getUserByName(String name) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<User> UserList = this.userMapper.selectByExample(example);
		if (UserList.isEmpty()) {
			return null;
		}
		return (User) UserList.get(0);
	}

	public AjaxResult checkUserName(String name) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<User> UserList = this.userMapper.selectByExample(example);
		if (UserList.isEmpty()) {
			return AjaxResult.ok();
		}
		return AjaxResult.ok(((User) UserList.get(0)).getName());
	}
}
