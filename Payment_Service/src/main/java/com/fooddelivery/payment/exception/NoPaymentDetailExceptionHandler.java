package com.fooddelivery.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class NoPaymentDetailExceptionHandler {
    @ControllerAdvice
    public class CustomerNotFoundExceptionHandler {
        @ExceptionHandler(value = {NoPaymentDetailException.class})
        public ResponseEntity<Object> handleCustomerNotFoundException(NoPaymentDetailException e){

            Exception exception = new Exception(e.getMessage(), HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
        }
    }

}
