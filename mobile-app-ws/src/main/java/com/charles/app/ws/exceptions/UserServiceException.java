package com.charles.app.ws.exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 8442496867384881316L;

    public UserServiceException(String message) {
        super(message);
    }

}
