package com.corretoraweb.ws.exceptions;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErrors {

    private List<String> errors;

    public ApiErrors(List<String> messageError) {
        this.errors = messageError;
    }

    public ApiErrors(String messageError) {
        this.errors = Arrays.asList(messageError);
    }

}
