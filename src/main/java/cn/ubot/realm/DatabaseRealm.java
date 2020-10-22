package cn.ubot.realm;

import cn.ubot.pojo.generator.User;
import cn.ubot.service.user.PermissionService;
import cn.ubot.service.user.RoleService;
import cn.ubot.service.user.UserService;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String userName = (String) principalCollection.getPrimaryPrincipal();
		Set<String> permissions = this.permissionService.listPermissions(userName);
		Set<String> roles = this.roleService.listRoleNames(userName);
		SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
		s.setStringPermissions(permissions);
		s.setRoles(roles);
		return s;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = token.getPrincipal().toString();
		User user = this.userService.getUserByName(userName);
		if (user.getStatus().intValue() == 0) {
			throw new LockedAccountException();
		}
		String passwordInDB = user.getPassword();
		String salt = user.getSalt();
		return new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
	}
}
