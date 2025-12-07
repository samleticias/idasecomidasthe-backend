package com.ifpi.idasecomidasthe.service.exception.store;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String message) {
        super(message);
    }
}