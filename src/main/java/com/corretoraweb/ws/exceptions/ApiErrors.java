package com.corretoraweb.ws.exceptions;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ApiErrors {

    private List<String> errors;
    private String method;
    private String errorCode;


    public ApiErrors(List<String> messageError, String method, String errorCode) {
        this.errors = messageError;
        this.method = method;
        this.errorCode = errorCode;
    }

    public ApiErrors(String messageError, String method, String errorCode) {
        this.errors = Arrays.asList(messageError);
        this.method = method;
        this.errorCode = errorCode;
    }

}
