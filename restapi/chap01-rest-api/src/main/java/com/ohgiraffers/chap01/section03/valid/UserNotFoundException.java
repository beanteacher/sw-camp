package com.ohgiraffers.chap01.section03.valid;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
    }
}
