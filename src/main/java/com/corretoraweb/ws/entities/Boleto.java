package com.corretoraweb.ws.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "cta_id_int", nullable = false)
    private Corretora corretora;
}
