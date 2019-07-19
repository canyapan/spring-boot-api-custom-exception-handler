package com.canyapan.example.apringbootapiexceptionexampleapp.controller;

import com.canyapan.example.apringbootapiexceptionexampleapp.exceptions.ErrorDetails;
import com.canyapan.example.apringbootapiexceptionexampleapp.exceptions.MyCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MyCustomException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(MyCustomException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getDetails(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
