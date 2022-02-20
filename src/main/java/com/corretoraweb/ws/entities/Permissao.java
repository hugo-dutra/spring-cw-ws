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
@Table(name = "permissao_prm", schema = "corretora_web")
public class Permissao {
    @Id
    @Column(name = "prm_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "prm_nome_txt")
    private String nome;
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "perfil")
    @JsonIgnore
    private List<PerfilPermissao> perfilPermissoes;
}
