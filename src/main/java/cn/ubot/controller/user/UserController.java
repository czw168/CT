package cn.ubot.controller.user;

import cn.ubot.common.AjaxResult;
import cn.ubot.common.EUComboBoxResult;
import cn.ubot.common.EUDataGridResult;
import cn.ubot.pojo.diy.user.RolePermission_;
import cn.ubot.pojo.diy.user.UserRole_;
import cn.ubot.pojo.generator.Permission;
import cn.ubot.service.user.PermissionService;
import cn.ubot.service.user.RoleService;
import cn.ubot.service.user.UserService;
import cn.ubot.utils.JsonUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({ "/user" })
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@RequiresRoles({ "admin" })
	@RequestMapping({ "/{page}" })
	public String showPage(@PathVariable String page) {
		return "/user/" + page;
	}

	@GetMapping({ "/listUser" })
	@ResponseBody
	EUDataGridResult listUser(Integer page, Integer rows) {
		return this.userService.listUser(page, rows);
	}

	@PostMapping({ "/addUser" })
	@ResponseBody
	AjaxResult addUser(@RequestBody JSONObject obj) {
		UserRole_ userRole_ = (UserRole_) JsonUtils.jsonToPojo(obj.toJSONString(), UserRole_.class);
		return this.userService.addUser(userRole_);
	}

	@PostMapping({ "/updateUser" })
	@ResponseBody
	AjaxResult updateUser(@RequestBody JSONObject obj) {
		UserRole_ userRole_ = (UserRole_) JsonUtils.jsonToPojo(obj.toJSONString(), UserRole_.class);
		return this.userService.updateUser(userRole_);
	}

	@PostMapping({ "/deleteUser" })
	@ResponseBody
	AjaxResult deleteUser(@RequestBody JSONObject obj) {
		Long id = obj.getLong("id");
		return this.userService.deleteUser(id);
	}

	@PostMapping({ "/checkUserName" })
	@ResponseBody
	AjaxResult checkUserName(@RequestBody JSONObject obj) {
		String name = obj.getString("name");
		return this.userService.checkUserName(name);
	}

	@PostMapping({ "/listRoleName" })
	@ResponseBody
	List<EUComboBoxResult> listRoleName() {
		return this.roleService.listRoleName();
	}

	@GetMapping({ "/listRole" })
	@ResponseBody
	EUDataGridResult listRole(Integer page, Integer rows) {
		return this.roleService.listRole(page, rows);
	}

	@PostMapping({ "/addRole" })
	@ResponseBody
	AjaxResult addRoleAndPermission(@RequestBody JSONObject obj) {
		String roleName = obj.getString("roleName");
		String roleDesc = obj.getString("roleDesc");
		JSONArray jsonArray = obj.getJSONArray("permissionNameList");
		List<String> permissionNameList = jsonArray.toJavaList(String.class);
		RolePermission_ rolePermission_ = new RolePermission_();
		rolePermission_.setRoleName(roleName);
		rolePermission_.setRoleDesc(roleDesc);
		rolePermission_.setPermissionNameList(permissionNameList);
		return this.roleService.addRole(rolePermission_);
	}

	@PostMapping({ "/updateRole" })
	@ResponseBody
	AjaxResult updateRole(@RequestBody JSONObject obj) {
		String id = obj.getString("id");
		String roleDesc = obj.getString("roleDesc");
		JSONArray jsonArray = obj.getJSONArray("permissionNameList");
		List<String> permissionNameList = jsonArray.toJavaList(String.class);
		RolePermission_ rolePermission_ = new RolePermission_();
		rolePermission_.setId(Long.valueOf(Long.parseLong(id)));
		rolePermission_.setRoleDesc(roleDesc);
		rolePermission_.setPermissionNameList(permissionNameList);
		return this.roleService.updateRole(rolePermission_);
	}

	@PostMapping({ "/deleteRole" })
	@ResponseBody
	AjaxResult deleteRole(@RequestBody JSONObject obj) {
		String id = obj.getString("id");
		return this.roleService.deleteRole(id);
	}

	@GetMapping({ "/listPermission" })
	@ResponseBody
	EUDataGridResult listPermission(Integer page, Integer rows) {
		return this.permissionService.listPermission(page, rows);
	}

	@PostMapping({ "/addPermission" })
	@ResponseBody
	AjaxResult addPermission(@RequestBody JSONObject obj) {
		Permission permission = (Permission) JsonUtils.jsonToPojo(obj.toJSONString(), Permission.class);
		return this.permissionService.addPermission(permission);
	}

	@PostMapping({ "/updatePermission" })
	@ResponseBody
	AjaxResult updatePermission(@RequestBody JSONObject obj) {
		Permission permission = (Permission) JsonUtils.jsonToPojo(obj.toJSONString(), Permission.class);
		return this.permissionService.updatePermission(permission);
	}

	@PostMapping({ "/deletePermission" })
	@ResponseBody
	AjaxResult deletePermission(@RequestBody JSONObject obj) {
		Long id = obj.getLong("id");
		return this.permissionService.deletePermission(id);
	}

	@GetMapping({ "/listPermission_" })
	@ResponseBody
	AjaxResult listPermission() {
		return this.permissionService.listPermission();
	}
}
