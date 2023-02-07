package com.employeecrud.employee_role.repository;

import com.employeecrud.employee_role.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UnitRepo extends JpaRepository<Unit,Integer> {
}
