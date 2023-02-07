package com.employeecrud.employee_role.repository;

import com.employeecrud.employee_role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
}
