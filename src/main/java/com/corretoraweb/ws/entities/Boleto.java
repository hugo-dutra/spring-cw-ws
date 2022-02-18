package com.corretoraweb.ws.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "boleto_blt", schema = "corretora_web")
public class Boleto {
    @Id
    @Column(name = "blt_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "blt_valor_num")
    private Double valor;
    @Column(name = "blt_data_emissao_dte")
    private Date dataEmissao;
    @Column(name = "blt_data_vencimento_dte")
    private Date dataVencimento;
    /*****RELACIONAMENTOS****/
    @ManyToOne
    @JoinColumn(name = "cta_id_int", nullable = false)
    private Corretora corretora;
}
