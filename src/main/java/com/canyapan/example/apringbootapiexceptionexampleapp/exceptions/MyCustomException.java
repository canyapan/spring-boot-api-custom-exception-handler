package com.canyapan.example.apringbootapiexceptionexampleapp.exceptions;

public class MyCustomException extends RuntimeException {
    private String details;

    public MyCustomException(String details) {
        super(details);
        setDetails(details);
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
