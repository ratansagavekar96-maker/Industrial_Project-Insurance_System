package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	
	

}
