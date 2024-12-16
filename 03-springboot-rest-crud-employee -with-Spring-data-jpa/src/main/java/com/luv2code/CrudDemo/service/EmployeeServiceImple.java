package com.luv2code.CrudDemo.service;

import com.luv2code.CrudDemo.dao.EmployeeRepository;
import com.luv2code.CrudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImple  implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImple(EmployeeRepository theEmployeeRepository){

        employeeRepository= theEmployeeRepository;
    }


    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override

    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee Dbemployee = null;
        if (result.isPresent()){
            Dbemployee=result.get();
        }else{
            throw new RuntimeException("did not find employee with this id");
        }
        return Dbemployee;
    }

    @Override

    public Employee save(Employee theEmployee) {

        return employeeRepository.save(theEmployee);
    }

    @Override

    public void DeleteById(int theId) {
        employeeRepository.deleteById(theId);

    }
}
