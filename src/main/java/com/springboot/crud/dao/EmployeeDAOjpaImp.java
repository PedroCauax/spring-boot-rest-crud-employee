package com.springboot.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.crud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOjpaImp implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOjpaImp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //exec
        List<Employee> employee = theQuery.getResultList();
        
        //result
        return employee;
    }

}
