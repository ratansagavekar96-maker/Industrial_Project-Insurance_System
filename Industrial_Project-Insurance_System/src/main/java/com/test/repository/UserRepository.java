package com.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public Optional<User> findByEmail(String email);
	
	
	 public  User findByEmailAndPassword(String email, String password);
	
	

}