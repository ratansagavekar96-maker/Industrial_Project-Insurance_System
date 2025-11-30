package com.test.service;

import java.util.List;

import com.test.entity.Role;

public interface RoleService {

    public Role saveRole(Role role);

    public Role getRoleById(Long id);
    
    public List<Role> getAllRoles(); 

    public void deleteRole(Long id);
}
