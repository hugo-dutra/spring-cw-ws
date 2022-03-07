package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.ClasseContrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClasseContratoRepository extends JpaRepository<ClasseContrato, Long> {
    List<ClasseContrato> findByCorretoraId(Long corretoraId);
}
