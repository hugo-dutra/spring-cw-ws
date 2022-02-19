package com.corretoraweb.ws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerGlobalController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors>  HandleRuntimeException(RuntimeException ex){
        String messageErro = ex.getMessage();
        return new ResponseEntity(messageErro,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrors> HandleRegraDeNegocioException(RegraDeNegocioException ex){
        String messageErro = ex.getMessage();
        return new ResponseEntity(messageErro,HttpStatus.BAD_REQUEST);
    }

}
