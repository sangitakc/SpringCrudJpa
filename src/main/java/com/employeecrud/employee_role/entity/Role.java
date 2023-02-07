package com.employeecrud.employee_role.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name="salary")
    private Integer salary;

    @Column(name="role_name")
    private String roleName;

//    @OneToOne(mappedBy = "role")
//    private Employee employee;

    public Role(){}

    public Role(Integer roleId, Integer salary, String roleName) {
        this.roleId = roleId;
        this.salary = salary;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
