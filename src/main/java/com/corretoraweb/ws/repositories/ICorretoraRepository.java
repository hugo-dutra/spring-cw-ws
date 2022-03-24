package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Corretora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICorretoraRepository extends JpaRepository<Corretora,Long> {
    Optional<Boolean> existsByEmail(String name);
}
