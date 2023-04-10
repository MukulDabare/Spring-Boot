package com.crud.webapp.main.serviceI;

import java.util.List;

import com.crud.webapp.main.model.Student;

public interface HomeService {
	
	public void saveStudent(Student s);

	public Iterable<Student> getAllStudent();
	
	public void deleteStudent(int rollno);
	
	public Student editStudent(int rollno);
	
	public void updateStudent(Student s);
	
	public List<Student> loginCheck(String username, String password);

}
