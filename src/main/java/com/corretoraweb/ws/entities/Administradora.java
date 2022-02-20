package com.corretoraweb.ws.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "administradora_adm", schema = "corretora_web")
public class Administradora {
    @Id
    @Column(name = "adm_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 255, message = "nome: Deve ter no máximo 255 caracteres")
    @Column(name = "adm_nome_txt", length = 255)
    private String nome;
}
