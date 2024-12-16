package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
         theStudents= new ArrayList<>();
        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("John","Cena"));
        theStudents.add(new Student("Sandy","Singh"));
        theStudents.add(new Student("Anant","Ambani"));
    }

    //define an endpoint gor "/students"- return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }


    //define endppoint or "/student/{studentID}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){


        //check the student against listsize
        if((studentId>theStudents.size())||(studentId<0)){
            throw new StudentNotFoundException("student not found for id : "+studentId);
        }


        return theStudents.get(studentId);
    }
}
