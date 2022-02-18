package com.corretoraweb.ws.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "dependente_dpd", schema = "corretora_web")
public class Dependente {
    @Id
    @Column(name = "dpd_id_int", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 500)
    @Column(name = "dpd_nome_txt", length = 500)
    private String nome;
    @Length(max = 500)
    @Column(name = "dpd_email_txt", length = 500)
    private String email;
    @Length(max = 11, min = 11)
    @Column(name = "dpd_cpf_txt", length = 11)
    private String cpf;
    @Column(name = "dpd_data_nasdimento_dte")
    private Date dataNascimento;
    /****RELACIONAMENTOS****/
    @ManyToOne
    @JoinColumn(name = "bnf_id_int", nullable = false)
    private Beneficiario beneficiario;

}
