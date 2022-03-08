package com.corretoraweb.ws.dtos.comissao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComissaoCreateDTO {
    private String nome;
    private Long tipoComissaoId;
    private Long tipoPagementoId;
    private Long contratoId;
}
