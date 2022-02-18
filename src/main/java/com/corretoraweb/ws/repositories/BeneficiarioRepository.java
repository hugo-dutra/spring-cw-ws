package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
