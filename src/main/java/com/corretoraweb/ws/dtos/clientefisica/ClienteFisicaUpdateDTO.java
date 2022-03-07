package com.corretoraweb.ws.dtos.clientefisica;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteFisicaUpdateDTO {
    private Long id;
    private String cpf;
    private Long clienteId;
}
