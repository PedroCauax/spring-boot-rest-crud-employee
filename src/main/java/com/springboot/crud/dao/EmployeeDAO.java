package com.springboot.crud.dao;

import java.util.List;

import com.springboot.crud.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();
    
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);









}
