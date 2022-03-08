package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoPagamentoRepository extends JpaRepository<TipoPagamento,Long> {
}
