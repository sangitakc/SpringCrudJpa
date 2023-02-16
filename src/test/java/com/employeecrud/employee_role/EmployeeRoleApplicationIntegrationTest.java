package com.employeecrud.employee_role;

import com.employeecrud.employee_role.controller.EmployeeController;
import com.employeecrud.employee_role.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@Transactional
public class EmployeeRoleApplicationIntegrationTest {

    @Autowired
    EmployeeController employeeController;
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void getEmployee() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employeeDetails/4").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empName").value("pooja"));
    }


    @Test
    public void saveEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmpName("lisa");
        employee.setRoleId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/employeeSave")
                        .content(objectMapper.writeValueAsString(employee))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empName").value("lisa"));

    }

    @Test
    public void getAllEmployee() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getAllDetails").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].empName").value("pooja"));


    }

}

