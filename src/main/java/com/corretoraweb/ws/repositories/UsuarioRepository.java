package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
