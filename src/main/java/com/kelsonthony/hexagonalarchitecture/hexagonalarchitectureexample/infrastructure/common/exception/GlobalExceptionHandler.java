package com.kelsonthony.hexagonalarchitecture.hexagonalarchitectureexample.infrastructure.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmailAlreadyExistsException.class, UserNotFoundException.class})
    public ResponseEntity<String> handleEmailAlreadyExistsException(Exception ex) {
        // Intenta obtener el código de estado desde @ResponseStatus
        ResponseStatus status = ex.getClass().getAnnotation(ResponseStatus.class);
        HttpStatus httpStatus = (status != null) ? status.value() : HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity.status(httpStatus).body(ex.getMessage());
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}