package com.employeecrud.employee_role.repository;

import com.employeecrud.employee_role.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
