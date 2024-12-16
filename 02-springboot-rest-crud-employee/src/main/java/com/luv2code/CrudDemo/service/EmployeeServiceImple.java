package com.luv2code.CrudDemo.service;

import com.luv2code.CrudDemo.dao.EmployeeDAO;
import com.luv2code.CrudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImple  implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImple(EmployeeDAO theEmployeeDAO){
       employeeDAO= theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll(){
        return employeeDAO.findALL();
    }

    @Override

    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee Save(Employee theEmployee) {
        return employeeDAO.Save(theEmployee);
    }

    @Override
    @Transactional
    public void DeleteById(int theId) {
        employeeDAO.DeleteById(theId);

    }
}
