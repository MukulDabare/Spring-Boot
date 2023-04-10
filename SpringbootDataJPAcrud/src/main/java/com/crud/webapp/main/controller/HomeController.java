package com.crud.webapp.main.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.webapp.main.model.Student;
import com.crud.webapp.main.serviceI.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService hs;

	@RequestMapping ("/")
	public String preLogin()
	{
		return "login";
	}
	
	@RequestMapping ("/*")
	public String errorPage()
	{
		return "error";
	}
	
	@RequestMapping ("/openregister")
	public String preRegister()
	{
		return "register";
	}
	
	@RequestMapping ("/save")
	public String saveStudent(@ModelAttribute Student s)
	{
		hs.saveStudent(s);
		return "login";
	}
	
	@RequestMapping ("/login")
	public String login(@RequestParam String username, @RequestParam String password, 
			             Model m)
	{
		if(username.equals("ADMIN") && password.equals("ADMIN"))
		{
			Iterable<Student> allStudent = hs.getAllStudent();
			m.addAttribute("data", allStudent);
			return "success";
		}
		else {
			List<Student> list = hs.loginCheck(username, password);
			if(!list.isEmpty())
			{
				m.addAttribute("data", list);
				return "success";
			}
		}
		
		return "login";
	}
	@RequestMapping ("/delete")
	public String deleteStudent(@RequestParam int rollno, Model m)
	{
		
	   	hs.deleteStudent(rollno);
	    Iterable<Student> allStudent = hs.getAllStudent();
		m.addAttribute("data", allStudent);
		return "success";
	}
	
	@RequestMapping ("/edit")
	public String editStudent(Model m,@RequestParam int rollno)
	{
		Student student = hs.editStudent(rollno);
		m.addAttribute("stu", student);
		return "edit";
	}
	
	@RequestMapping ("/update")
	public String updateStudent(Model m, @ModelAttribute Student s)
	{
		hs.updateStudent(s);
		Iterable<Student> allStudent = hs.getAllStudent();
		m.addAttribute("data", allStudent);
		return "success";
	}
}
