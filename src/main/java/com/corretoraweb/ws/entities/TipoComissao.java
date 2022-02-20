package com.corretoraweb.ws.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tipo_comissao_tcm", schema = "corretora_web")
public class TipoComissao {
    @Id
    @Column(name = "tcm_id_int")
    private Long id;
    @Length(max = 255, message = "nome: Deve ter entre 1 e 255 caracteres")
    @Column(name = "tcm_nome_txt", length = 255)
    private String nome;
    @Column(name = "tcm_percentual_associado_num")
    private Double percentualAssociado;
}
