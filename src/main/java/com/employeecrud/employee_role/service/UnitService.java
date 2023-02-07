package com.employeecrud.employee_role.service;

import com.employeecrud.employee_role.dto.ProductDetails;
import com.employeecrud.employee_role.entity.Product;
import com.employeecrud.employee_role.entity.Unit;
import com.employeecrud.employee_role.repository.ProductRepo;
import com.employeecrud.employee_role.repository.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UnitRepo unitRepo;

    public Unit saveUnit(Unit unit){
        return unitRepo.save(unit);
    }


    public Optional<Unit> getUnitName(Integer id){
        return unitRepo.findById(id);
    }

    public ProductDetails productDetails(Integer id){
        ProductDetails productDetails1=new ProductDetails();
        Product product=productRepo.findById(id).orElse(null);
        productDetails1.setProductName(product.getProductName());
        productDetails1.setProductRate(product.getProductRate());

        Unit unit=unitRepo.findById(product.getUnitId()).orElse(null);
        productDetails1.setUnitName(unit.getUnitName());

        return productDetails1;


    }

}
