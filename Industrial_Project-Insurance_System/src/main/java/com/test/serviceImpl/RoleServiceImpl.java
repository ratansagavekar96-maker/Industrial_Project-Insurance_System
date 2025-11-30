package com.test.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.entity.Role;
import com.test.exception.RoleAlreadyExistsException;
import com.test.repository.RoleRepository;
import com.test.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {

        // Prevent duplicate role names
        if (roleRepository.findByRoleName(role.getRoleName()) != null) {
            throw new RoleAlreadyExistsException("Role already exists with name: " + role.getRoleName());
        }

        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {   // ★ Required API
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}

