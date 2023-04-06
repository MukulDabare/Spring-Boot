package com.login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.daoi.HomeDaoI;
import com.login.model.Student;
import com.login.servicei.HomeServiceI;
@Service
public class HomeServiceImpl implements HomeServiceI {

	@Autowired
	HomeDaoI hdi;
	
	@Override
	public void setStudent(Student s) {
		hdi.setStudent(s);
		
	}

}
