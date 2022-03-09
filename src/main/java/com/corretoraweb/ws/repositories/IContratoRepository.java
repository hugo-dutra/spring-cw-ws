package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContratoRepository extends JpaRepository<Contrato,Long> {
    public List<Contrato> findByUsuarioId(Long usuarioId);
    public List<Contrato> findByModalidadePlanoId(Long modalidadePlanoId);
    public List<Contrato> findByTipoContratoId(Long tipoContratoId);
    public List<Contrato> findByAdministradoraId(Long administradoraContratoId);
}
