package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
