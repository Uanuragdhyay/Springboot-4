package com.luv2code.CrudDemo.dao;

import com.luv2code.CrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findALL();


    Employee findById(int theId);

    Employee Save(Employee theEmployee);

    void DeleteById(int theId);

}
