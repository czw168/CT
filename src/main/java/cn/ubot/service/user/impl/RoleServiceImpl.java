package cn.ubot.service.user.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.user.UserMapper_;
import cn.ubot.mapper.generator.RoleMapper;
import cn.ubot.mapper.generator.RolePermissionMapper;
import cn.ubot.mapper.generator.UserRoleMapper;
import cn.ubot.pojo.diy.user.RolePermission_;
import cn.ubot.pojo.generator.Role;
import cn.ubot.pojo.generator.RoleExample;
import cn.ubot.pojo.generator.RolePermission;
import cn.ubot.pojo.generator.RolePermissionExample;
import cn.ubot.pojo.generator.User;
import cn.ubot.pojo.generator.UserRole;
import cn.ubot.pojo.generator.UserRoleExample;
import cn.ubot.service.user.RoleService;
import cn.ubot.service.user.UserService;
import cn.ubot.utils.ExceptionUtils;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private UserMapper_ userManagerMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private UserService userService;

	public Set<String> listRoleNames(String userName) {
		Set<String> result = new HashSet<String>();
		List<Role> roles = listRoles(userName);
		for (Role role : roles) {
			result.add(role.getName());
		}
		return result;
	}

	public List<Role> listRoles(String userName) {
		List<Role> roles = new ArrayList<Role>();
		User user = this.userService.getUserByName(userName);
		if (null == user) {
			return roles;
		}
		return listRoles(user);
	}

	public List<Role> listRoles(User user) {
		List<Role> roles = new ArrayList<Role>();
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(user.getId());
		List<UserRole> userRoles = this.userRoleMapper.selectByExample(example);
		for (UserRole userRole : userRoles) {
			Role role = this.roleMapper.selectByPrimaryKey(userRole.getRid());
			roles.add(role);
		}
		return roles;
	}

	public List<EUComboBoxResult> listRoleName() {
		List<EUComboBoxResult> l = new ArrayList<EUComboBoxResult>();
		RoleExample example = new RoleExample();
		List<Role> RoleList = this.roleMapper.selectByExample(example);
		for (Role role : RoleList) {
			EUComboBoxResult eur2 = new EUComboBoxResult(role.getId() + "", role.getName(), null);
			l.add(eur2);
		}
		return l;
	}

	public EUDataGridResult listRole(Integer page, Integer rows) {
		EUDataGridResult result = new EUDataGridResult();
		RoleExample roleExample = new RoleExample();
		List<Role> roleList = this.roleMapper.selectByExample(roleExample);
		List<RolePermission_> rolePermissionList = new ArrayList<RolePermission_>();
		for (Role role : roleList) {
			RolePermission_ rp = new RolePermission_();
			rp.setId(role.getId());
			rp.setRoleDesc(role.getDesc());
			rp.setRoleName(role.getName());
			List<String> permissionNameList = this.userManagerMapper
					.getPermissionNameByid(Long.valueOf(role.getId().longValue()));
			rp.setPermissionNameList(permissionNameList);
			rolePermissionList.add(rp);
		}
		result.setRows(rolePermissionList);
		PageInfo<RolePermission_> pageInfo = new PageInfo<RolePermission_>(rolePermissionList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addRole(RolePermission_ rolePermission_) {
		try {
			Role role = new Role();
			role.setName(rolePermission_.getRoleName());
			role.setDesc(rolePermission_.getRoleDesc());
			this.roleMapper.insertSelective(role);
			List<String> permissionNameList = rolePermission_.getPermissionNameList();
			for (String permissionName : permissionNameList) {
				RoleExample example = new RoleExample();
				RoleExample.Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(rolePermission_.getRoleName());
				List<Role> roleList = this.roleMapper.selectByExample(example);
				Long rid = ((Role) roleList.get(0)).getId();
				Long pid = Long.valueOf(Long.parseLong(permissionName));
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRid(rid);
				rolePermission.setPid(pid);
				this.rolePermissionMapper.insertSelective(rolePermission);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult updateRole(RolePermission_ rolePermission_) {
		Role role = new Role();
		role.setId(rolePermission_.getId());
		role.setDesc(rolePermission_.getRoleDesc());
		try {
			RolePermissionExample example = new RolePermissionExample();
			RolePermissionExample.Criteria criteria = example.createCriteria();
			criteria.andRidEqualTo(role.getId());
			this.rolePermissionMapper.deleteByExample(example);
			List<String> permissionNameList = rolePermission_.getPermissionNameList();
			for (int i = 0; i < permissionNameList.size(); i++) {
				RolePermission rp = new RolePermission();
				rp.setRid(role.getId());
				rp.setPid(Long.valueOf(Long.parseLong((String) permissionNameList.get(i))));
				this.rolePermissionMapper.insert(rp);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), ExceptionUtils.getStackTrace(e));
		}
		return AjaxResult.ok();
	}

	public AjaxResult deleteRole(String id) {
		this.roleMapper.deleteByPrimaryKey(Long.valueOf(Long.parseLong(id)));
		RolePermissionExample example = new RolePermissionExample();
		RolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andRidEqualTo(Long.valueOf(Long.parseLong(id)));
		this.rolePermissionMapper.deleteByExample(example);
		return AjaxResult.ok();
	}
}
