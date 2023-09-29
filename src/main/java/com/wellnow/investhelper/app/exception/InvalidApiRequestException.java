package com.wellnow.investhelper.app.exception;

public class InvalidApiRequestException extends Exception {
    public InvalidApiRequestException(String errorString) {
        super(errorString);
    }
}
