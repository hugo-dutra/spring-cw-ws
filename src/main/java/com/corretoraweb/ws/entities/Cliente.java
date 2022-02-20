package com.corretoraweb.ws.entities;

import com.corretoraweb.ws.customvalidators.CpfCnpj;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "cliente_clt", schema = "corretora_web")
public class Cliente {
    @Id
    @Column(name = "clt_id_int", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 15, min = 1, message = "cep: deve ter entre 1 e 15 caracteres")
    @Column(name = "clt_cep_txt", length = 15)
    private String cep;
    @Length(max = 300, min = 1, message = "endereco: deve ter entre 1 e 300 caracteres")
    @Column(name = "clt_endereco_txt", length = 300)
    private String endereco;
    @Length(max = 100, min = 1, message = "cidade: deve ter entre 1 e 100 caracteres")
    @Column(name = "clt_cidade_txt", length = 100)
    private String cidade;
    @Length(max = 2, min = 2, message = "uf: deve ter 2 caracteres")
    @Column(name = "clt_uf_txt", length = 2)
    private String uf;
    @Email
    @Length(max = 500, min = 1, message = "email: deve ter entre 1 e 500 caracteres")
    @Column(name = "clt_email_txt", length = 500)
    private String email;
    @Length(max = 500, min = 1, message = "nome: deve ter entre 1 e 500 caracteres")
    @Column(name = "clt_nome_txt", length = 500)
    private String nome;
    @CpfCnpj
    @Length(min = 11, max = 14, message = "cpfCnpj: deve ter entre 11 e 14 caracteres")
    @Column(name = "clt_cpf_cnpj_txt", length = 14)
    private String cpfCnpj;
    @NotNull(message = "pessoaFisica: Não pode ser nulo")
    @Column(name = "clt_pessoaFisica_bit")
    private Boolean pessoaFisica;
    /*****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne()
    @JoinColumn(name = "cta_id_int", nullable = false)
    private Corretora corretora;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Telefone> telefones;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Beneficiario> beneficiarios;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "usr_id_int")
    private Usuario usuario;
}













