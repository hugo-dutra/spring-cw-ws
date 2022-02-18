package com.corretoraweb.ws.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Entity
@Table(name = "telefone_beneficiario_tbn", schema = "corretora_web")
public class TelefoneBeneficiario {
    @Id
    @Column(name = "tbn_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 13)
    @Column(name = "tbn_telefone_txt", length = 13)
    private String telefone;
    @Column(name = "tbn_thatsapp_bin")
    private Boolean whatsApp;
    @Length(max = 500)
    @Column(name = "tbn_observacao_txt", length = 500)
    private String observacao;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "bnf_id_int", nullable = false)
    private Beneficiario beneficiario;
}
