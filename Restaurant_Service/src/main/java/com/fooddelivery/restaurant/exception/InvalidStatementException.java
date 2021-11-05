package com.fooddelivery.restaurant.exception;


public class InvalidStatementException extends RuntimeException {
    public InvalidStatementException(){
    }
    public InvalidStatementException(String message){
        super(message);
    }
    public InvalidStatementException(String message,Throwable cause){
        super(message, cause);
    }
    public InvalidStatementException(Throwable cause){
        super(cause);
    }
}
