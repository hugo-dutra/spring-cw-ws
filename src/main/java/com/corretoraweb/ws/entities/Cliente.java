package com.corretoraweb.ws.entities;

import com.corretoraweb.ws.customvalidators.CpfCnpj;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "cliente_clt", schema = "corretora_web")
public class Cliente {
    @Id
    @Column(name = "clt_id_int", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 15, min = 1)
    @Column(name = "clt_cep_txt", length = 15)
    private String cep;
    @Length(max = 300, min = 1)
    @Column(name = "clt_endereco_txt", length = 300)
    private String endereco;
    @Length(max = 100, min = 1)
    @Column(name = "clt_cidade_txt", length = 100)
    private String cidade;
    @Length(max = 2, min = 2)
    @Column(name = "clt_uf_txt", length = 2)
    private String uf;
    @Email
    @Length(max = 500, min = 1)
    @Column(name = "clt_email_txt", length = 500)
    private String email;
    @Length(max = 500, min = 1)
    @Column(name = "clt_nome_txt", length = 500)
    private String nome;
    @CpfCnpj
    @Length(min = 11, max = 14)
    @Column(name = "clt_cpf_cnpj_txt", length = 14)
    private String cpfCnpj;
    @NotNull
    @Column(name = "clt_pessoaFisica_bit")
    private Boolean pessoaFisica;
    /*****RELACIONAMENTOS****/
    @ManyToOne()
    @JoinColumn(name = "cta_id_int", nullable = false)
    private Corretora corretora;
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "cliente")
    private List<Beneficiario> beneficiarios;


}













