package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.TelefoneDependente;
import com.corretoraweb.ws.repositories.ITelefoneDependenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneDependenteService {
    private final ITelefoneDependenteRepository telefoneDependenteRepository;

    private List<TelefoneDependente> findAll(){
        return telefoneDependenteRepository.findAll();
    }
}
