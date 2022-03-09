package com.corretoraweb.ws.dtos.dependente;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DependenteUpdateDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Date dataNascimento;
    private Long beneficiarioId;
}
