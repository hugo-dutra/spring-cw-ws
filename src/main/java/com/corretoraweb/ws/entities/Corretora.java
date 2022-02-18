package com.corretoraweb.ws.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Data
@Entity
@Table(name = "corretora_cta", schema = "corretora_web")
public class Corretora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cta_id_int", nullable = false)
    private Long id;
    @Column(name = "cta_nome_txt", length = 200)
    @Length(min = 1, max = 200, message = "Campo nome deve possuir entre 1 e 200 caracteres")
    private String nome;
    @Email
    @Column(name = "cta_email_txt", length = 500)
    @Length(min = 1, max = 500, message = "Campo email deve possuir entre 1 e 500 caracteres")
    private String email;
    @Column(name = "cta_telefone_txt", length = 13)
    @Length(min = 1, max = 13, message = "Campo telefone deve possuir entre 1 e 13 caracteres")
    private String telefone;
    /*****RELACIONAMENTOS****/
    @OneToMany(mappedBy = "corretora")
    private List<Boleto> boletos;
    @OneToMany(mappedBy = "corretora")
    private List<Cliente> clientes;
}