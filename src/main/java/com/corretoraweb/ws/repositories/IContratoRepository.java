package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContratoRepository extends JpaRepository<Contrato,Long> {
}
