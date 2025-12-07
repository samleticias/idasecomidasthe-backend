package com.ifpi.idasecomidasthe.exception;

import com.ifpi.idasecomidasthe.service.exception.category.CategoryNotFoundException;
import com.ifpi.idasecomidasthe.service.exception.login.CustomAuthenticationException;
import com.ifpi.idasecomidasthe.service.exception.store.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<StandardError> customAuthenticationException(CustomAuthenticationException exception) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;    // 401
        StandardError response = new StandardError(status.value(), "Erro de autenticação.", exception.getMessage());
        return ResponseEntity.status(status.value()).body(response);
    }

    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<StandardError> storeNotFoundException(StoreNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;    // 404
        StandardError response = new StandardError(status.value(), "Loja não encontrada", exception.getMessage());
        return ResponseEntity.status(status.value()).body(response);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<StandardError> categoryNotFoundException(CategoryNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;    // 404
        StandardError response = new StandardError(status.value(), "Categoria não encontrada", exception.getMessage());
        return ResponseEntity.status(status.value()).body(response);
    }

}
