package com.employeecrud.employee_role.mapper;

import com.employeecrud.employee_role.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeedetailsMapper implements RowMapper<EmployeeDto> {

    @Override
    public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setEmpName(rs.getString("emp_name"));
        employeeDto.setSalary(rs.getInt("salary"));
        employeeDto.setRoleName(rs.getString("role_name"));

        return employeeDto;
    }
}
