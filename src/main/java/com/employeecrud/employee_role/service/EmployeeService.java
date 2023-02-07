package com.employeecrud.employee_role.service;

import com.employeecrud.employee_role.dto.EmployeeDto;
import com.employeecrud.employee_role.entity.Employee;
import com.employeecrud.employee_role.entity.Role;
import com.employeecrud.employee_role.repository.EmployeeRepo;
import com.employeecrud.employee_role.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RoleRepo roleRepo;

    public Employee saveemployee(Employee employee){
        return employeeRepo.save(employee);
    }

        public Employee updateEmployee (Employee employee){
        Employee employee1=employeeRepo.findById(employee.getEmpId()).orElse(null);
        employee1.setEmpName(employee.getEmpName());
//        employee1.setRole(employee.getRole());
        employeeRepo.save(employee1);
        return employee1;
    }

    public EmployeeDto employeeDetails(Integer id){
        EmployeeDto employeeDto=new EmployeeDto();
        Employee employee=employeeRepo.findById(id).orElse(null);
        employeeDto.setEmpName(employee.getEmpName());
//        Role role=employee.getRole();


        Role role=roleRepo.findById(employee.getRoleId()).orElse(null);
        employeeDto.setRoleName(role.getRoleName());
        employeeDto.setSalary(role.getSalary());

        return employeeDto;



    }

    public Employee employeeUpdate(EmployeeDto employeeDto){
        Employee employee=employeeRepo.findById(employeeDto.getId()).orElse(null);
        employee.setEmpName(employeeDto.getEmpName());
        employeeRepo.save(employee);

//        Role role=employee.getRole();
//   Role role=roleRepo.findById(employee.getRoleId()).orElse(null);
//        role.setRoleName(employeeDto.getRoleName());
//        roleRepo.save(role);

        return employee;

    }

}
