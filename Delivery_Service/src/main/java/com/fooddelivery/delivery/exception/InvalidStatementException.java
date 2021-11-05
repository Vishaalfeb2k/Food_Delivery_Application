package com.fooddelivery.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidStatementException extends RuntimeException
{
    public InvalidStatementException(String msg)
    {
        super(msg);
    }
}
