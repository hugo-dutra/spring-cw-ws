package com.corretoraweb.ws.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerGlobalController {

    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> HandleRegraDeNegocioException(RegraDeNegocioException ex){
        ApiErrors apiErrors = new ApiErrors(ex.getMessage(), ex.getLocation(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity(apiErrors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> HandleMethodArgumentNotValidException(ConstraintViolationException ex){
        List<String> validationsErrors = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            validationsErrors.add(constraintViolation.getMessage());
        }
        ApiErrors apiErrors = new ApiErrors(validationsErrors, ex.getClass().getName(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity(apiErrors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors>  HandleRuntimeException(RuntimeException ex){
        ApiErrors apiErrors = new ApiErrors(ex.getMessage(),ex.getClass().getName(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity(apiErrors,HttpStatus.BAD_REQUEST);
    }


}
