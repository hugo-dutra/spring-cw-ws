package com.corretoraweb.ws.dtos.contrato;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ContratoUpdateDTO {
    private Long id;
    private Double valor;
    private String numeroContrato;
    private Date inicioVigencia;
    private Double valorDesconto;
    private Date dataAssinaturaContrato;
    private Long usuarioId;
    private Long modalidadePlanoId;
    private Long tipoContratoId;
    private Long classeContratoId;
    private Long administradoraId;
}
