package com.luv2code.CrudDemo.rest;

import com.luv2code.CrudDemo.entity.Employee;
import com.luv2code.CrudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    //quick and dirty : inject employee dao,using constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){

        employeeService=theEmployeeService;
    }


    //expose"/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee Not Found for Id :- "+employeeId);
        }
        return  theEmployee;
    }
    // add new employees in api
    @PostMapping("/employees")
    public Employee addemployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id in json set that id to 0
        // this is to force a save of a new data... instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }

    //adding method for PUT /employees(for updation of values)
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //adding a delete mapping for an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.findById(employeeId);

        //throw exception if not found

        if (dbEmployee==null){
            throw new RuntimeException("Employee not founf for id : "+employeeId);
        }
        employeeService.DeleteById(employeeId);
        return "Deleted employee id :- "+ employeeId;
    }




}
