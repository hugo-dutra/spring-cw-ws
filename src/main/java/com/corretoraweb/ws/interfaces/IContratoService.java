package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.contrato.ContratoCreateDTO;
import com.corretoraweb.ws.dtos.contrato.ContratoUpdateDTO;
import com.corretoraweb.ws.entities.Contrato;

import java.util.List;
import java.util.Optional;

public interface IContratoService {
    public Contrato create(ContratoCreateDTO contratoCreateDTO);
    public Contrato update(ContratoUpdateDTO contratoUpdateDTO);
    public Optional<Contrato> findById(Long contratoId);
    public List<Contrato> findByUsuarioId(Long usuarioId);
    public List<Contrato> findByModalidadePlanoId(Long modalidePlanoId);
    public List<Contrato> findByTipoContratoId(Long tipoContratoId);
    public List<Contrato> findByAdministradoraId(Long administradoraId);
    public void deleteById(Long contratoId);
}
