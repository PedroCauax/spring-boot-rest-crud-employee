package com.springboot.crud.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;

import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;
    
    private JsonMapper jsonMapper;

    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper) {
        employeeService = theEmployeeService;
        jsonMapper = theJsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }
    
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
       
        Employee theEmployee = employeeService.findById(id);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        return theEmployee;
    }
    

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }


    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        Employee tempEmployee = employeeService.findById(id);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        employeeService.deleteById(id);
        return tempEmployee;
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id,
         @RequestBody Map<String, Object> patchPayload) {
        Employee tempEmployee = employeeService.findById(id);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        if(patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + id);
        }

        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayload);

        Employee dbEmployee = employeeService.save(patchedEmployee);
        return dbEmployee;
    }

}