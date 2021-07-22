package com.example.MaryCatqapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msg) {
        super(msg);
        System.out.println(this.getMessage());
    }
}