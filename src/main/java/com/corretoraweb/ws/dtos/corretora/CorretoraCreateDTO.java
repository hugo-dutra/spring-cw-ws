package com.corretoraweb.ws.dtos.corretora;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CorretoraCreateDTO {
    private String nome;
    private String email;
    private String telefone;
}
