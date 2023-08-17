package com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	

	@RequestMapping("/")
	public String preLogin()
	{
		System.out.println("in controller ");
		return "login";
	}
	
	@RequestMapping("/*")
	public String errorPage()
	{
		return "error";
	}
}
