package com.login.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.daoi.HomeDaoI;
import com.login.model.Student;
@Repository
public class HomeDaoImpl implements HomeDaoI {
	@Autowired 
	SessionFactory sf;

	@Override
	public void setStudent(Student s) {
	 Session session = sf.openSession();
	 session.save(s);
	 session.beginTransaction().commit();
		
	}

}
