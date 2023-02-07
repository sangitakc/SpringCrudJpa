package com.employeecrud.employee_role.entity;


import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="p_id")
    private Integer productId;

    @Column(name="p_name")
    private String productName;

    @Column(name = "p_rate")
    private Integer productRate;

    @Column(name="u_id")
    private Integer unitId;

    public Product(){}

    public Product(Integer productId, String productName, Integer productRate, Integer unitId) {
        this.productId = productId;
        this.productName = productName;
        this.productRate = productRate;
        this.unitId = unitId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductRate() {
        return productRate;
    }

    public void setProductRate(Integer productRate) {
        this.productRate = productRate;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
}
