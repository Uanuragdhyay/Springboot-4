package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SttudentRestExceptionHandler {

//add exception handling code

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // create a studentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();


        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamps(System.currentTimeMillis());



        //return response entity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // add a new exception handler to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handleException(Exception exccc){
        StudentErrorResponse error = new StudentErrorResponse();


        error.setMessage(exccc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamps(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }

}
