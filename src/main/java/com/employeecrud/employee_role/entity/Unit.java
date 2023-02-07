package com.employeecrud.employee_role.entity;


import javax.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue
    @Column(name="unit_id")
    private Integer unitId;

    @Column(name = "unit_name")
    private String unitName;

    public Unit(){}

    public Unit(Integer unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
