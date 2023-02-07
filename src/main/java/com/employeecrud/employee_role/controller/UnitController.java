package com.employeecrud.employee_role.controller;

import com.employeecrud.employee_role.dto.ProductDetails;
import com.employeecrud.employee_role.entity.Unit;
import com.employeecrud.employee_role.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UnitController {

    @Autowired
    UnitService unitService;


    @RequestMapping(value = "/unitSave", method = RequestMethod.POST)
    public Unit saveUnit(@RequestBody Unit unit) {
        return unitService.saveUnit(unit);
    }


    @RequestMapping(value = "/getUnitName/{id}", method = RequestMethod.GET)
    public Optional<Unit> getUnitName(@PathVariable Integer id) {
        return unitService.getUnitName(id);
    }

    @RequestMapping(value="/productDetails/{id}",method = RequestMethod.GET)
    public ProductDetails productDetails(@PathVariable Integer id){
        return unitService.productDetails(id);
    }


}
