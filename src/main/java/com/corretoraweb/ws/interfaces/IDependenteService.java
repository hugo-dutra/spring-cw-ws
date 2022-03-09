package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.dependente.DependenteCreateDTO;
import com.corretoraweb.ws.dtos.dependente.DependenteUpdateDTO;
import com.corretoraweb.ws.entities.Dependente;

import java.util.List;
import java.util.Optional;

public interface IDependenteService {
    public Dependente create(DependenteCreateDTO dependenteCreateDTO);
    public Dependente update(DependenteUpdateDTO dependenteUpdateDTO);
    public Optional<Dependente> findById(Long dependenteId);
    public List<Dependente> findByBeneficiarioId(Long beneficiarioId);
    public void deleteById(Long beneficiarioId);




}
