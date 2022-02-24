package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public List<Usuario> findByCorretoraId(Long corretoraId);

}
