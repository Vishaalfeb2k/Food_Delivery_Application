package com.fooddelivery.customer.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerException {
    private final String message;
    private final HttpStatus httpStatus;

    public CustomerException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
