package com.employeecrud.employee_role;


import com.employeecrud.employee_role.dto.EmployeeDto;
import com.employeecrud.employee_role.entity.Employee;
import com.employeecrud.employee_role.repository.EmployeeRepo;
import com.employeecrud.employee_role.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class EmployeeRoleApplicationServiceUnitTest {

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepo employeeRepo;

    @Test
    public void saveemployee() throws Exception{
        Employee employee=new Employee();
        employee.setEmpId(1);
        employee.setEmpName("sujata");
        employee.setRoleId(2);

        Mockito.when(employeeRepo.save(any(Employee.class))).thenReturn(employee);
        Employee employee1=employeeService.saveemployee(employee);
        assertEquals(employee.getEmpName(),employee1.getEmpName());


    }


    @Test
    public void getAllDetails() throws Exception{
        List<Employee> employees=new ArrayList<>();
        Employee employee=new Employee();
        employee.setEmpId(1);
        employee.setEmpName("sujata");
        employee.setRoleId(2);

        employees.add(employee);


        Mockito.when(employeeRepo.findAll()).thenReturn(employees);

        List<Employee> employeeDtos=employeeService.getAllEmployee();
        assertEquals("sujata",employeeDtos.get(0).getEmpName());

    }

    @Test
    public void findById() throws Exception{

        Employee employee=new Employee();
        employee.setEmpId(4);
        employee.setEmpName("pooja");
        employee.setRoleId(1);

        Mockito.when(employeeRepo.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(employee));

        EmployeeDto employeeDto=employeeService.employeeDetails(4);
        assertEquals("pooja",employeeDto.getEmpName());


    }



}
