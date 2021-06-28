package com.overpathz.spring.rest.exception;


public class NoSuchEmployee extends RuntimeException {
    public NoSuchEmployee(String message) {
        super(message);
    }
}
