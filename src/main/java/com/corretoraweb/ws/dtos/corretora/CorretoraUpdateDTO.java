package com.corretoraweb.ws.dtos.corretora;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorretoraUpdateDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
