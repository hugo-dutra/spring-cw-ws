package com.corretoraweb.ws.dtos.clientejuridica;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteJuridicaCreateDTO {
    private String cnpj;
    private Long clienteId;
}
