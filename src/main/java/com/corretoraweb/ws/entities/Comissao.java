package com.corretoraweb.ws.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "comissao_cms", schema = "corretora_web")
public class Comissao {
    @Id
    @Column(name = "cms_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cms_nome_txt")
    private String nome;
}
