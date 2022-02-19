package com.corretoraweb.ws.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegraDeNegocioException extends RuntimeException{

    private String message;
    private String location;

    public RegraDeNegocioException(String message){
        super(message);
    }

    public RegraDeNegocioException(String message,String location){
        this.location = location;
        this.message = message;
    }
}
