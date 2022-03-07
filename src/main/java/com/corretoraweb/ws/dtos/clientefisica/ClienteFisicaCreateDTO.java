package com.corretoraweb.ws.dtos.clientefisica;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteFisicaCreateDTO {
    private String cpf;
    private Long clienteId;
}
