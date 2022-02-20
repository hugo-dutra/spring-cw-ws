package com.corretoraweb.ws.dtos.cliente;

import com.corretoraweb.ws.customvalidators.CpfCnpj;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteUpdateDTO {
    @NotNull(message = "id: Não pode ser nulo")
    private Long id;
    @Length(max = 15, min = 1, message = "cep: deve ter entre 1 e 15 caracteres")
    private String cep;
    @Length(max = 300, min = 1, message = "endereco: deve ter entre 1 e 300 caracteres")
    private String endereco;
    @Length(max = 100, min = 1, message = "cidade: deve ter entre 1 e 100 caracteres")
    private String cidade;
    @Length(max = 2, min = 2, message = "uf: deve ter 2 caracteres")
    private String uf;
    @Length(max = 500, min = 1, message = "email: deve ter entre 1 e 500 caracteres")
    private String email;
    @Length(max = 500, min = 1, message = "nome: deve ter entre 1 e 500 caracteres")
    private String nome;
    @Length(min = 11, max = 14, message = "cpfCnpj: deve ter entre 11 e 14 caracteres")
    @CpfCnpj(message = "CPF ou CNPJ inválido")
    private String cpfCnpj;
    @NotNull(message = "pessoa física não pode ser nulo")
    private Boolean pessoaFisica;
}




















