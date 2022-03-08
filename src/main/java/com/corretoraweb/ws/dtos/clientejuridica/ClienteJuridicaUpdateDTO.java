package com.corretoraweb.ws.dtos.clientejuridica;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteJuridicaUpdateDTO {
    private Long id;
    private String cnpj;
    private Long clienteId;
}
