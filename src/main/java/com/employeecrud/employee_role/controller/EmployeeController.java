package com.employeecrud.employee_role.controller;

import com.employeecrud.employee_role.dto.EmployeeDto;
import com.employeecrud.employee_role.entity.Employee;
import com.employeecrud.employee_role.repository.EmployeeRepo;
import com.employeecrud.employee_role.service.EmployeeService;
import com.employeecrud.employee_role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employeeSave", method = RequestMethod.POST)
    public Employee employeeSave(@RequestBody Employee employee) {
        return employeeService.saveemployee(employee);

    }

    @RequestMapping(value = "/employeeUpdate", method = RequestMethod.PUT)
    public Employee employeeUpdate(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value="/employeeDetails/{id}",method = RequestMethod.GET)
    public EmployeeDto employeeDetails(@PathVariable Integer id){
        return employeeService.employeeDetails(id);
    }

    @RequestMapping(value="/updateEmployee",method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody EmployeeDto employeeDto){ return employeeService.employeeUpdate(employeeDto);}

}
