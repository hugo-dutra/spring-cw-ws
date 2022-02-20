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
@Table(name = "perfil_permissao_pep", schema = "corretora_web")
public class PerfilPermissao {
    @Id
    @Column(name = "pep_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "per_id_int")
    private Perfil perfil;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "prm_id_int")
    private Permissao permissao;
}
