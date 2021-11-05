package com.fooddelivery.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeliveryTeamNotFoundException extends RuntimeException
{
    public DeliveryTeamNotFoundException(String message)
    {
        super(message);
    }
}
