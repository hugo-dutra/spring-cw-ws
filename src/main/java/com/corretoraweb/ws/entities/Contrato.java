package com.corretoraweb.ws.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "contrato_ctr", schema = "corretora_web")
public class Contrato {
    @Id
    @Column(name = "crt_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ctr_valor_num")
    private Double valor;
    @Length(max = 100, message = "numeroContrato: Pode ter no máximo 100 caracteres")
    @Column(name = "ctr_numero_contrato_txt", length = 100)
    private String numeroContrato;
    @Column(name = "ctr_inicio_vigencia_dte")
    private Date inicioVigencia;
    @Column(name = "ctr_valor_desconto_num")
    private Double valorDesconto;
    @Column(name = "ctr_data_assinatura_contrato_dte")
    private Date dataAssinaturaContrato;
}
