package com.agilesolutions.hiscores.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionController {

    @ExceptionHandler(value = ResourceNotFoundException.class)

    public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

}
