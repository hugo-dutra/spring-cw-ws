package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Dependente;
import com.corretoraweb.ws.repositories.DependenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DependenteService {
    private final DependenteRepository dependenteRepository;

    public List<Dependente> findAll(){
        return dependenteRepository.findAll();
    }
}
