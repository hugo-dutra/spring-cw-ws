package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.ClienteFisica;
import com.corretoraweb.ws.entities.ClienteJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteJuridicaRepository extends JpaRepository<ClienteJuridica, Long> {
    public List<ClienteJuridica> findByClienteId(Long clienteId);
}
