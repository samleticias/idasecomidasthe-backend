package com.ifpi.idasecomidasthe.infra.exception;

public class TokenNotProviderException extends RuntimeException {
    public TokenNotProviderException(String message) {
        super(message);
    }
}
