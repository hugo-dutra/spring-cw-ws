package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBoletoRepository extends JpaRepository<Boleto,Long> {
    public List<Boleto> findByCorretoraId(Long id);
}
