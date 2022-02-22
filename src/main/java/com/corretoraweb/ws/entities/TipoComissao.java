package com.corretoraweb.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

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
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "cta_id_int")
    private Corretora corretora;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "tipoComissao")
    @JsonIgnore
    private List<Comissao> comissoes;
}
