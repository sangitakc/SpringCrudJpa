package com.employeecrud.employee_role;

import com.employeecrud.employee_role.controller.EmployeeController;
import com.employeecrud.employee_role.dto.EmployeeDto;
import com.employeecrud.employee_role.entity.Employee;
import com.employeecrud.employee_role.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeRoleApplicationUnitTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    EmployeeService employeeService;


    @Test
    public void getEmployee() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1);
        employeeDto.setEmpName("sujata");
        employeeDto.setSalary(10000);
        employeeDto.setRoleName("developer");


        Mockito.when(employeeService.employeeDetails(Mockito.any(Integer.class))).thenReturn(employeeDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/employeeDetails/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empName").value("sujata"));

    }

    @Test
    public void saveEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmpName("pooja");
        employee.setEmpId(2);
        employee.setRoleId(3);

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(employeeService.saveemployee(Mockito.any(Employee.class))).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employeeSave")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empId").value("2"))
                .andExpect(jsonPath("$.empName").value("pooja"));


    }

    @Test
    public void getAllDetails() throws Exception {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("sujata");
        employee.setRoleId(2);

        employees.add(employee);

        Employee employee1 = new Employee();
        employee.setEmpId(2);
        employee.setEmpName("Suraj");
        employee.setRoleId(9);

        employees.add(employee1);
        Mockito.when(employeeService.getAllEmployee()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/getAllDetails"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }


}
