package com.example.ensetbillingservice.exceptions;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*@Value(value = "${data.exception.message1}")
    private String message1;*/

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception exception) {
        return new ResponseEntity("exception message", HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(value = ClientCustomerNotFoundException.class)
    public ResponseEntity exception(ClientCustomerNotFoundException exception) {
        return new ResponseEntity(exception.getException_message(), HttpStatus.NOT_FOUND);
    }*/
}
