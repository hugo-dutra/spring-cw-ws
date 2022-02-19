package com.corretoraweb.ws.dtos;

import com.corretoraweb.ws.customvalidators.CpfCnpj;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteCreateDTO {
    @Length(max = 15, min = 1)
    private String cep;
    @Length(max = 300, min = 1)
    private String endereco;
    @Length(max = 100, min = 1)
    private String cidade;
    @Length(max = 2, min = 2)
    private String uf;
    @Length(max = 500, min = 1)
    private String email;
    @Length(max = 500, min = 1)
    private String nome;
    @Length(min = 11, max = 14)
    @CpfCnpj
    private String cpfCnpj;
    @NotNull
    private Boolean pessoaFisica;
    @NotNull
    private Long corretora;
}




















