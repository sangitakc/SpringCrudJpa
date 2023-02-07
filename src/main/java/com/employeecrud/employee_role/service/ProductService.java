package com.employeecrud.employee_role.service;


import com.employeecrud.employee_role.entity.Employee;
import com.employeecrud.employee_role.entity.Product;
import com.employeecrud.employee_role.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
   ProductRepo productRepo;

    public Product saveProduct(Product product){

        return productRepo.save(product);
    }

    public Product updateProduct (Product product,Integer id){
        Product product1=productRepo.findById(id).orElse(null);
        product1.setProductName(product.getProductName());
        product1.setProductRate(product.getProductRate());
        product1.setUnitId(product.getUnitId());
        productRepo.save(product1);
        return product1;
    }
}
