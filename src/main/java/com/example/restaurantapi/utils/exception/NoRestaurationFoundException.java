package com.example.restaurantapi.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoRestaurationFoundException extends Exception {
    public NoRestaurationFoundException(String message) {
        super(message);
    }

}
