package com.example.ensetbillingservice.exceptions;

public class ClientCustomerNotFoundException extends Exception {
    public String message;
    public ClientCustomerNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
