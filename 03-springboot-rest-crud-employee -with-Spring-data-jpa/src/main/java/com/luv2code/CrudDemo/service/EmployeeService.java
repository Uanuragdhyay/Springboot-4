package com.luv2code.CrudDemo.service;

import com.luv2code.CrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void DeleteById(int theId);








}
