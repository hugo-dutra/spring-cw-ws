package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Comissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IComissaoRepository extends JpaRepository<Comissao, Long> {
    public List<Comissao> findByContratoId(Long contratoId);
}
