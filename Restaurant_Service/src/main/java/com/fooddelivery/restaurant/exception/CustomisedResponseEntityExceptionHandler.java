package com.fooddelivery.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception
    {
        ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RestaurantNotFoundException.class)
    public final ResponseEntity<Object> handleRestaurantNotFoundException(Exception ex,WebRequest request) throws Exception
    {
        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidStatementException.class)
    public final ResponseEntity<Object> handlerInvalidStatementException(Exception ex1,WebRequest request1) throws Exception
    {
        ExceptionResponse exceptionResponse1=new ExceptionResponse(new Date(),ex1.getMessage(),request1.getDescription(false));
        return new ResponseEntity(exceptionResponse1, HttpStatus.NOT_FOUND);
    }
}
