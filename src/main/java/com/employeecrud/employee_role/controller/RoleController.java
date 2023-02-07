package com.employeecrud.employee_role.controller;


import com.employeecrud.employee_role.entity.Role;
import com.employeecrud.employee_role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;


    @RequestMapping(value = "/roleSave", method = RequestMethod.POST)
    public Role roleSave(@RequestBody Role role) {
        return roleService.saveRole(role);

    }

    @RequestMapping(value = "/roleUpdate", method = RequestMethod.PUT)
    public Role roleUpdate(@RequestBody Role role) {
        return roleService.roleUpdate(role);
    }

    @RequestMapping(value = "/roleView/{id}", method = RequestMethod.GET)
    public Role roleView(@PathVariable Integer id) {

        return roleService.viewRole(id);

    }


}
