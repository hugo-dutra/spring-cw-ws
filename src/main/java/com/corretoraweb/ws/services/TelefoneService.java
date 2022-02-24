package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Telefone;
import com.corretoraweb.ws.repositories.ITelefoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneService {

    private final ITelefoneRepository telefoneRepository;

    public List<Telefone> findAll(){
        return telefoneRepository.findAll();
    }
}
