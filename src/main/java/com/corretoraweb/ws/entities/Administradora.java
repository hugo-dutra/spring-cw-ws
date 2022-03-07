package com.corretoraweb.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "cta_id_int")
    private Corretora corretora;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "administradora")
    @JsonIgnore
    private List<Contrato> contratos;
}
