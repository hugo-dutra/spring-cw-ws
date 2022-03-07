package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Administradora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAdministradoraRepository extends JpaRepository<Administradora,Long> {
    List<Administradora> findByCorretoraId(Long corretoraId);
}
