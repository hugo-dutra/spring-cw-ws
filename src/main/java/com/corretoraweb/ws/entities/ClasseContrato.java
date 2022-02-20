package com.corretoraweb.ws.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "classe_contrato_clc", schema = "corretora_web")
public class ClasseContrato {
    @Id
    @Column(name = "clc_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 255, message = "nome: Deve ter no máximo 255 caracteres")
    @Column(name = "clc_nome_txt", length = 255)
    private String nome;
}
