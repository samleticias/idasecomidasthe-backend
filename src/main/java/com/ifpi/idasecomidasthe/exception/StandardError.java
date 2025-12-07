package com.ifpi.idasecomidasthe.exception;

public record StandardError(
        int status,
        String error,
        String message
) {
}
