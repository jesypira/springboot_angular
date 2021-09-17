package com.pira.springboot_angular.exception;

public class UserException extends RuntimeException{

    public UserException(String login){
        super("User already registered for login "+ login+".");
    }
}
