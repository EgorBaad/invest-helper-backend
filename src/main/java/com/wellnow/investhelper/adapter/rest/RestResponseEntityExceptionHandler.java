package com.wellnow.investhelper.adapter.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.wellnow.investhelper.app.exception.InvalidApiRequestException;
import com.wellnow.investhelper.app.exception.InvalidTokenException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidTokenException.class)
    protected ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException e, WebRequest req) {
        return handleExceptionInternal(e, "Invalid token", new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
    }

    @ExceptionHandler(InvalidApiRequestException.class)
    protected ResponseEntity<Object> handleInvalidApiRequestExceptionJava(InvalidApiRequestException e,
            WebRequest req) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
    }
}
