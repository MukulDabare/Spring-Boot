package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping (value = "/")
	public String preLogin()
	{
		System.out.println("In controller");
		return "welcome";
	}
}
