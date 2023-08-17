package com.webapp.main.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.main.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
