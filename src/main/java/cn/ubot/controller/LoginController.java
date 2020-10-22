package cn.ubot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.ubot.common.AjaxResult;
import cn.ubot.config.DynamicDataSource;

@Controller
public class LoginController {
	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	@ResponseBody
	public AjaxResult login(Model model, String name, String password) {
		
		// 重点： 实际操作证明，切换的时候最好清空一下
		DynamicDataSource.clearCustomerType();
		// 切换数据源，设置后 就OK了。可以随时切换过来（在controller层切换）
		//DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceSqlite);
		DynamicDataSource.setCustomerType(DynamicDataSource.dataSourceMysql);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		try {
			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute("subject", subject);
			return AjaxResult.ok();
		} catch (LockedAccountException lae) {
			return AjaxResult.build(Integer.valueOf(400), "The user is locked");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return AjaxResult.build(Integer.valueOf(400), "Authentication failed");
		}
	}
}
