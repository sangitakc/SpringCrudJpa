package com.employeecrud.employee_role.controller;


import com.employeecrud.employee_role.entity.Product;
import com.employeecrud.employee_role.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/productSave", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "/productUpdate/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        return productService.updateProduct(product,id);
    }


    }
