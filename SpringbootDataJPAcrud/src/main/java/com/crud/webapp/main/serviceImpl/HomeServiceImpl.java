package com.crud.webapp.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.webapp.main.model.Student;
import com.crud.webapp.main.repositoryI.HomeRepository;
import com.crud.webapp.main.serviceI.HomeService;

@Repository
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	HomeRepository hr;

	@Override
	public void saveStudent(Student s) {
	
		hr.save(s);
	}

	@Override
	public Iterable<Student> getAllStudent() {
		 
		return hr.findAll();
	}

	@Override
	public void deleteStudent(int rollno) {
		
		hr.deleteById(rollno);
//		Optional<Student> id = hr.findById(rollno);
//		Student s = id.get();
//		hr.delete(s);
	}

	@Override
	public Student editStudent(int rollno) {
		
		Optional<Student> id = hr.findById(rollno);
		Student s = id.get();
		return s;
		
	}

	@Override
	public void updateStudent(Student s) {
		hr.save(s);
	}

	@Override
	public List<Student> loginCheck(String username, String password) {
		List<Student> list = hr.findByUsernameAndPassword(username, password);
		return list;
	}

}
