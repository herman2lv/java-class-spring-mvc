package com.hrm.springmvcdemo.service.exception;


public class ServerInternalException extends AppException {

    public ServerInternalException(String message) {
        super(message);
    }

    public ServerInternalException(String message, Throwable cause) {
        super(message, cause);
    }

}
