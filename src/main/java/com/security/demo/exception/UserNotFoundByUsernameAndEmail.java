package com.security.demo.exception;

public class UserNotFoundByUsernameAndEmail extends RuntimeException{

    //create a custom exception for user not found by username And email
    public UserNotFoundByUsernameAndEmail(String message) {
        super(message);
    }
}
