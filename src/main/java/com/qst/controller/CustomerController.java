package com.qst.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qst.po.Customer;
import com.qst.service.CustomerService;
import com.qst.util.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String username,String password,Model model,HttpSession session){
		Customer customer = customerService.selectByNamePwd(username, password);
		if(customer!=null){
			session.setAttribute("CUSTOMER_SESSION", customer);
			return "redirect:list.action";
		}
		model.addAttribute("msg", "用户名 或密码错误！");
		return "login";
	}
	
	@RequestMapping("/main.action")
	public String toMain(){
		return "main";
	}
	
	@RequestMapping("/list.action")
	public String list(
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="3")Integer rows,
			String username,String gender,String startBirthday,String endBirthday,
			Model model){
		Page<Customer> pagelist = customerService.selectCustomerList(page, rows, username,gender,startBirthday,endBirthday);
		model.addAttribute("page",pagelist);
		//model.addAttribute("customer",customer);
		model.addAttribute("username", username);
		model.addAttribute("gender",gender);
		model.addAttribute("startBirthday",startBirthday);
		model.addAttribute("endBirthday",endBirthday);
		return "main";
	}
}
