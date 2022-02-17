package com.corretoraweb.ws.entities;

import com.corretoraweb.ws.customvalidators.CpfCnpj;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "cliente_clt", schema = "corretora_web")
public class Cliente {
    @Id
    @Column(name = "clt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "clt_cep_txt")
    private String cep;
    @NotNull
    @Column(name = "clt_endereco_txt")
    private String endereco;
    @NotNull
    @Column(name = "clt_cidade_txt")
    private String cidade;
    @NotNull
    @Column(name = "clt_uf_txt")
    private String uf;
    @Email
    @NotNull
    @Column(name = "clt_email_txt")
    private String email;
    @NotNull
    @Column(name = "clt_nome_txt")
    private String nome;
    @CpfCnpj
    @Column(name = "clt_cpf_cnpj_txt")
    private String cpfCnpj;
    @NotNull
    @Column(name = "clt_pessoaFisica_bit")
    private Boolean pessoaFisica;
}
















