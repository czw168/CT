package cn.ubot.service.user.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.mapper.diy.user.UserMapper_;
import cn.ubot.mapper.generator.PermissionMapper;
import cn.ubot.mapper.generator.RoleMapper;
import cn.ubot.mapper.generator.RolePermissionMapper;
import cn.ubot.pojo.generator.Permission;
import cn.ubot.pojo.generator.PermissionExample;
import cn.ubot.pojo.generator.Role;
import cn.ubot.pojo.generator.RolePermission;
import cn.ubot.pojo.generator.RolePermissionExample;
import cn.ubot.service.user.PermissionService;
import cn.ubot.service.user.RoleService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private UserMapper_ userManagerMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private RoleService roleService;

	public Set<String> listPermissions(String userName) {
		Set<String> result = new HashSet<String>();
		List<Role> roles = this.roleService.listRoles(userName);
		List<RolePermission> rolePermissions = new ArrayList<RolePermission>();
		for (Role role : roles) {
			RolePermissionExample example = new RolePermissionExample();
			example.createCriteria().andRidEqualTo(role.getId());
			List<RolePermission> rps = this.rolePermissionMapper.selectByExample(example);
			rolePermissions.addAll(rps);
		}
		for (RolePermission rolePermission : rolePermissions) {
			Permission p = this.permissionMapper.selectByPrimaryKey(rolePermission.getPid());
			result.add(p.getName());
		}
		return result;
	}

	public EUDataGridResult listPermission(Integer page, Integer rows) {
		EUDataGridResult result = new EUDataGridResult();
		PageHelper.startPage(page.intValue(), rows.intValue());
		PermissionExample example = new PermissionExample();
		List<Permission> listPermission = this.permissionMapper.selectByExample(example);
		result.setRows(listPermission);
		PageInfo<Permission> pageInfo = new PageInfo<Permission>(listPermission);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	public AjaxResult addPermission(Permission permission) {
		try {
			this.permissionMapper.insertSelective(permission);
			return AjaxResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), "Duplicate permission name");
		}
	}

	public AjaxResult updatePermission(Permission permission) {
		try {
			PermissionExample example = new PermissionExample();
			PermissionExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(permission.getId());
			this.permissionMapper.updateByExampleSelective(permission, example);
			return AjaxResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(500), "Duplicate permission name");
		}
	}

	public AjaxResult deletePermission(Long id) {
		this.permissionMapper.deleteByPrimaryKey(id);
		return AjaxResult.ok();
	}

	public AjaxResult listPermission() {
		PermissionExample example = new PermissionExample();
		List<Permission> listPermission = this.permissionMapper.selectByExample(example);
		return AjaxResult.ok(listPermission);
	}
}
