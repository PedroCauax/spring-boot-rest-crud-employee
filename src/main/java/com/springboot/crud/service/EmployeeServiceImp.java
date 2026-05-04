package com.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.dao.EmployeeDAO;
import com.springboot.crud.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {


    private EmployeeDAO employeeDAO;


    @Autowired
    public EmployeeServiceImp(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
