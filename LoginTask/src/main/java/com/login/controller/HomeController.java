package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.model.Student;
import com.login.servicei.HomeServiceI;

@Controller
public class HomeController {
	
	
	@Autowired
	HomeServiceI hsi;
	
    @RequestMapping (value = "/")
	public String preLogin()
	{
		
		return "login";
	}
    @RequestMapping (value = "/register")
    public String register()
    {
    	
    	return "register";
    }
    @RequestMapping (value = "/save")
    public String save(@ModelAttribute Student s)
    {
    	hsi.setStudent(s);
    	return "login";
    }
    
  
    
    
}
