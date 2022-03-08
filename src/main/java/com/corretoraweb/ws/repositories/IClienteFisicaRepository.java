package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.ClienteFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteFisicaRepository extends JpaRepository<ClienteFisica, Long> {
    public List<ClienteFisica> findByClienteId(Long clienteId);
}
