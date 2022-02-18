package com.corretoraweb.ws.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "beneficiario_bnf", schema = "corretora_web")
public class Beneficiario {
    @Id
    @Column(name = "bnf_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(max = 500)
    @Column(name = "bnf_nome_txt", length = 500)
    private String nome;
    @Size(max = 500)
    @Column(name = "bnf_email_txt", length = 500)
    private String email;
    @Column(name = "bnf_data_nascimento_dte")
    private Date dataNascimento;
    @Size(min=11, max = 11)
    @Column(name = "bnf_cpf_txt", length = 11)
    private String cpf;
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "clt_id_int", nullable = false)
    private Cliente cliente;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "beneficiario")
    private List<TelefoneBeneficiario> telefonesBeneficiarios;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "beneficiario")
    private List<Dependente> dependentes;


}
