package com.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
      @RequestMapping ("/")
	    public String preLogin()
	    {
	    	System.out.println("Login Page");
	    	return "welcome";
	    }
}
