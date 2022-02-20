package com.corretoraweb.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "corretora_cta", schema = "corretora_web")
public class Corretora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cta_id_int", nullable = false)
    private Long id;
    @Length(min = 1, max = 200, message = "nome: deve possuir entre 1 e 200 caracteres")
    @Column(name = "cta_nome_txt", length = 200)
    private String nome;
    @Email(message = "email: formato de email inválido")
    @Length(min = 1, max = 500, message = "email: deve possuir entre 1 e 500 caracteres")
    @Column(name = "cta_email_txt", length = 500)
    private String email;
    @Length(min = 1, max = 13, message = "telefone: deve possuir entre 1 e 13 caracteres")
    @Column(name = "cta_telefone_txt", length = 13)
    private String telefone;
    /*****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "corretora")
    @JsonIgnore
    private List<Boleto> boletos;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "corretora")
    @JsonIgnore
    private List<Cliente> clientes;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "corretora")
    @JsonIgnore
    private List<Usuario> usuarios;

}