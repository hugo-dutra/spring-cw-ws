package com.corretoraweb.ws.dtos.classecontrato;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClasseContratoCreateDTO {
    private String nome;
    private Long corretoraId;
    private Long tipoContratoId;
}
