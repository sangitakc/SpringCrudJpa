package com.employeecrud.employee_role.entity;


import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="emp_id")
    private Integer empId;

    @Column(name="emp_name")
    private String empName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
//    private Role role;

    @Column(name="role_id")
    private Integer roleId;

    public Employee(){};

//    public Employee(Integer empId, String empName, Role role) {
//        this.empId = empId;
//        this.empName = empName;
//        this.role = role;
//    }


    public Employee(Integer empId, String empName, Integer roleId) {
        this.empId = empId;
        this.empName = empName;
        this.roleId = roleId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
