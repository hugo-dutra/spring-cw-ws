package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    public List<Cliente> findByCorretoraId(Long id);
}
