package com.corretoraweb.ws.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente_clt", schema = "corretora_web")
public class Cliente {
    @Id
    @Column(name = "clt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clt_cep_txt")
    private String cep;
    @Column(name = "clt_endereco_txt")
    private String endereco;
    @Column(name = "clt_cidade_txt")
    private String cidade;
    @Column(name = "clt_uf_txt")
    private String uf;
    @Column(name = "clt_email_txt")
    private String email;
    @Column(name = "clt_nome_txt")
    private String nome;
    @Column(name = "clt_cpf_cnpj_txt")
    private String cpfCnpj;
    @Column(name = "clt_pessoaFisica_bit")
    private Boolean pessoaFisica;





}
