package com.solvd.carina.demo.services.excpetions;

public class NoUserFundException extends RuntimeException{

    public NoUserFundException(String message) {
        super(message);
    }
}
