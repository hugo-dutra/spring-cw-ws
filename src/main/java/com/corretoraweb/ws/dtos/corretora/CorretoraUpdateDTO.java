package com.corretoraweb.ws.dtos.corretora;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CorretoraUpdateDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public CorretoraUpdateDTO(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}
