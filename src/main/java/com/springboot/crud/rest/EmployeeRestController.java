package com.springboot.crud.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.dao.EmployeeDAO;
import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;
    

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }
    

}
