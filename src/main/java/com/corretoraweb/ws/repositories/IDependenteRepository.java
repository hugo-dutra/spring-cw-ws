package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDependenteRepository extends JpaRepository<Dependente,Long> {
    public List<Dependente> findByBeneficiarioId(Long beneficiarioId);
}
