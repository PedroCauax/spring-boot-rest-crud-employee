package com.springboot.crud.dao;

import java.util.List;

import com.springboot.crud.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();
    
}
