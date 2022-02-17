package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
