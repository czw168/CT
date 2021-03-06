
package cn.ubot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	@RequestMapping(value = { "/login" }, method = { RequestMethod.GET })
	public String login() {
		return "login";
	}

	@RequestMapping({ "/index" })
	public String index() {
		return "index";
	}

	@RequestMapping({ "/reportMenu" })
	public String reportMenu() {
		return "reportMenu";
	}

	@RequestMapping({ "/unauthorized" })
	public String noPerms() {
		return "unauthorized";
	}
}
