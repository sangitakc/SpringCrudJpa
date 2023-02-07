package com.employeecrud.employee_role.repository;

import com.employeecrud.employee_role.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
