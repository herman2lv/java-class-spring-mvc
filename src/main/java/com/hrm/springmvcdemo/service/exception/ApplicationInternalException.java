package com.hrm.springmvcdemo.service.exception;


public class ApplicationInternalException extends ApplicationException {

    public ApplicationInternalException(String message) {
        super(message);
    }

    public ApplicationInternalException(String message, Throwable cause) {
        super(message, cause);
    }

}
