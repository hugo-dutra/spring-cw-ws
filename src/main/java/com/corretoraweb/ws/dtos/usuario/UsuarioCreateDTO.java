package com.corretoraweb.ws.dtos.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreateDTO {
    private String nome;
    private String email;
    private String senha;
    private Long corretoraId;
    private Long perfilId;
}
