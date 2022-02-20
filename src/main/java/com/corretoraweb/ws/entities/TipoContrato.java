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
@Table(name = "tipo_contrato_tco", schema = "corretora_web")
public class TipoContrato {
    @Id
    @Column(name = "tco_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 255, message = "nome: Deve ter no máximo 255 caracteres")
    @Column(name = "tco_nome_txt",length = 255)
    private String nome;
}
