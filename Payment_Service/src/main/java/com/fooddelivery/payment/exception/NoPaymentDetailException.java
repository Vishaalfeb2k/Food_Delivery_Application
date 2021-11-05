package com.fooddelivery.payment.exception;


public class NoPaymentDetailException extends RuntimeException{

    public NoPaymentDetailException(String message) {
        super(message);
    }

    public NoPaymentDetailException(String message, Throwable cause) {
        super(message, cause);
    }
}
