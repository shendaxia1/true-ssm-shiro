package com.wx.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/page")
public class PageController {
	@RequestMapping(value="/toLogin")
	public String login() {
		return "login";
	}
	@RequiresRoles("2")
	@RequestMapping("/toAdmin")
	public String toAdmin() {
		return "admin";
	}
	@RequestMapping("/toFail")
	public String toFail() {
		return "fail";
	}

}
