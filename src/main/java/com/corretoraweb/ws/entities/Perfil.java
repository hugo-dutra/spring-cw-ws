package com.corretoraweb.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "perfil_per", schema = "corretora_web")
public class Perfil {

    @Id
    @Column(name = "per_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "per_nome_txt")
    private String nome;
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "perfil")
    @JsonIgnore
    private List<Usuario> usuarios;
    @ManyToOne
    @JoinColumn(name = "cta_id_int")
    private Corretora corretora;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "perfil")
    @JsonIgnore
    private List<PerfilPermissao> perfilPermissoes;


}
