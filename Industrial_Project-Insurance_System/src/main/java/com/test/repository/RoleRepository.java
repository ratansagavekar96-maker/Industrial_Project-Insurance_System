package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	 Role findByRoleName(String roleName);   //Duplicate check

}
