package com.employeecrud.employee_role;


import com.employeecrud.employee_role.dto.EmployeeDto;
import com.employeecrud.employee_role.entity.Employee;
import com.employeecrud.employee_role.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class EmployeeRoleApplicationServiceIntegrationTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public  void getAll() throws Exception{

        List<Employee> employee=employeeService.getAllEmployee();

        assertEquals("pooja",employee.get(0).getEmpName());


    }

    @Test
    public void saveEmployee() throws Exception{
        Employee employee=new Employee();
        employee.setEmpName("lovey1");
        employee.setRoleId(1);
        Employee employee1=employeeService.saveemployee(employee);
        assertEquals("lovey1",employee1.getEmpName());

    }

    @Test
    public void getById() throws Exception{
        Integer id=4;
        EmployeeDto employeeDto =employeeService.employeeDetails(id);

        assertEquals("pooja",employeeDto.getEmpName());
    }
}
