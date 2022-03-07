package com.corretoraweb.ws.dtos.administradora;

import com.corretoraweb.ws.entities.Corretora;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AdministradoraCreateDTO {
    @Length(max = 255, message = "nome: Deve ter no máximo 255 caracteres")
    private String nome;
    @NotNull(message = "corretoraId: Campo não pode ser Nulo")
    private Long corretoraId;
}
