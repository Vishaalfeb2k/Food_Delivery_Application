package com.fooddelivery.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CustomerNotFoundExceptionHandler {
    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException e){

        Exception exception = new Exception(e.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }
}
