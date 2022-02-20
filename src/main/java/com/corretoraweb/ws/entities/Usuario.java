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
@Table(name = "usuario_usr", schema = "corretora_web")
public class Usuario {
    @Id
    @Column(name = "usr_id_int", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 500, message = "nome: deve possuir no máximo 250 caracteres")
    @Column(name = "usr_nome_txt", length = 250)
    private String nome;
    @Email(message = "Informe um email válido")
    @Length(max = 500, message = "email: deve possuir no máximo 500 caracteres")
    @Column(name = "usr_email_txt", length = 500)
    private String email;
    @Length(max = 500, message = "senha: deve possuir no máximo 250 caracteres")
    @Column(name = "usr_senha_txt", length = 250)
    private String senha;
    @Length(max = 250, message = "salt: deve possuir no máximo 250 caracteres")
    @Column(name = "usr_salt_txt", length = 250)
    private String salt;
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne()
    @JoinColumn(name = "cta_id_int")
    private Corretora corretora;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Cliente> cliente;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "per_id_int")
    private Perfil perfil;

}
