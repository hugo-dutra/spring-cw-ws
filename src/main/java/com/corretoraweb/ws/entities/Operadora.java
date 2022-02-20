package com.corretoraweb.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "operadora_ope", schema = "corretora_web")
public class Operadora {
    @Id
    @Column(name = "ope_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ope_nome_txt", length = 255)
    private String nome;
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "operadora")
    @JsonIgnore
    private List<ModalidadePlano> modalidadesPlanos;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "cta_id_int", nullable = false)
    private Corretora corretora;
}
