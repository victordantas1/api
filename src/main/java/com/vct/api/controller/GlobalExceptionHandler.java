package com.vct.api.controller;

import com.vct.api.domain.model.dto.UserDTO;
import com.vct.api.exception.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Date;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> error(IllegalArgumentException error, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        StandardError stError = new StandardError(Instant.now(), status.value(),error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(stError);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> error(NoSuchElementException error, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError stError = new StandardError(Instant.now(), status.value(),error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(stError);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<StandardError> error(Throwable error, HttpServletRequest request) {
        error = new Throwable("Unexpected Error");
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError stError = new StandardError(Instant.now(), status.value(), error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(stError);
    }

}
