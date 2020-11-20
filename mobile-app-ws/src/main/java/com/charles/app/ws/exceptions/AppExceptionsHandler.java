package com.charles.app.ws.exceptions;

import com.charles.app.ws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String erroMessageDescription = ex.getLocalizedMessage();

        if(erroMessageDescription == null) erroMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), erroMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest request) {

        String erroMessageDescription = ex.getLocalizedMessage();

        if(erroMessageDescription == null) erroMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), erroMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(Exception ex, WebRequest request) {

        String erroMessageDescription = ex.getLocalizedMessage();

        if(erroMessageDescription == null) erroMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), erroMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
