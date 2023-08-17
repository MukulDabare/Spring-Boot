package com.crud.webapp.main.repositoryI;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.webapp.main.model.Student;

@Repository
public interface HomeRepository extends CrudRepository<Student, Integer> {

	public List<Student> findByUsernameAndPassword(String username, String password);
	
	//findAllByColumn1AndColumn2 -- camelCase
}
