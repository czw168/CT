package cn.ubot.pojo.diy.user;

import java.util.List;

public class RolePermission_ {
	private Long id;
	private String roleName;
	private String roleDesc;
	private String permissionName;
	private List<String> permissionNameList;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<String> getPermissionNameList() {
		return this.permissionNameList;
	}

	public void setPermissionNameList(List<String> permissionNameList) {
		this.permissionNameList = permissionNameList;
	}
}
