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
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employee = theQuery.getResultList();
        return employee;
    }

    @Override
    public Employee findById(int theId) {
       Employee theEmployee = entityManager.find(Employee.class, theId);
       return theEmployee;  
    }   

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = findById(theId);
        if (theEmployee != null) {
            entityManager.remove(theEmployee);
        }
    }

}
