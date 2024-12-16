package com.luv2code.CrudDemo.dao;

import com.luv2code.CrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImple  implements EmployeeDAO{

//define field for Entitymanager
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImple(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }





    @Override
    public List<Employee> findALL(){

        //create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);

        // execute and get result list
        List<Employee> employees=theQuery.getResultList();

        //return results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee =entityManager.find(Employee.class,theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee Save(Employee theEmployee) {
        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return saved employee
        return dbEmployee;
    }

    @Override
    public void DeleteById(int theId) {

        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        //delete employee
        entityManager.remove(theEmployee);

    }
}
