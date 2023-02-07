package com.employeecrud.employee_role.service;

import com.employeecrud.employee_role.entity.Role;
import com.employeecrud.employee_role.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoleService {

    @Autowired
    RoleRepo roleRepo;

    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    public Role roleUpdate(Role role) {
        Role role1 = roleRepo.findById(role.getRoleId()).orElseThrow();
        role1.setSalary(role.getSalary());
        role1.setRoleName(role.getRoleName());
        roleRepo.save(role1);
        return role1;
    }

    public Role viewRole(Integer id) {
        Role role = roleRepo.findById(id).orElse(null);
        return role;

    }
}
