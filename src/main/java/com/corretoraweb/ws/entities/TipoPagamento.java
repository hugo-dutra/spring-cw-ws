package com.corretoraweb.ws.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pagamento_tip", schema = "corretora_web")
public class TipoPagamento {
    @Id
    @Column(name = "tip_id_int")
    private Long id;
    @Length(max = 255, message = "nome: Deve ter no máximo 255 caracteres")
    @Column(name = "tip_nome_txt", length = 255)
    private String nome;
}
