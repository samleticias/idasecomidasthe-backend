package com.ifpi.idasecomidasthe.service.exception.login;

public class CustomAuthenticationException extends RuntimeException {
    public CustomAuthenticationException(String message) {
        super(message);
    }
}
