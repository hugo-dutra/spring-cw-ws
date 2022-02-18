package com.corretoraweb.ws.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Entity
@Table(name = "telefone_dependente_tde", schema = "corretora_web")
public class TelefoneDependente {
    @Id
    @Column(name = "tde_id_int")
    private Long id;
    @Length(max = 13)
    @Column(name = "tde_telefone_txt", length = 13)
    private String telefone;
    @Column(name = "tde_whatsapp_bin")
    private Boolean whatsApp;
    @Length(max = 500)
    @Column(name = "tde_observacao_txt", length = 500)
    private String observacao;
    /****RELACIONAMENTOS****/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "dpd_id_int")
    private Dependente dependente;

}
