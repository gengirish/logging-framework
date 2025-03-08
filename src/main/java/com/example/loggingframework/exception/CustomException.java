package com.example.loggingframework.exception;

/**
 * Custom exception for the application.
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
