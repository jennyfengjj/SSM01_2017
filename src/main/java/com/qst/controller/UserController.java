package com.qst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login.action")
	public String login(){
		return "redirect:main.action";
	}
	@RequestMapping("/main.action")
	public String main(){
		return "main";
	}
}
