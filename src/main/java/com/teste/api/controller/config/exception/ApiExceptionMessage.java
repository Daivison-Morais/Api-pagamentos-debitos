package com.teste.api.controller.config.exception;

import org.springframework.http.HttpStatus;

public class ApiExceptionMessage extends Exception {

    protected final HttpStatus status;

    public ApiExceptionMessage(HttpStatus status, String error) {
        super(error);
        this.status = status;

    }

}