package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPerfilRepository extends JpaRepository<Perfil,Long> {
    public List<Perfil> findByCorretoraId(Long corretoraId);
}
