package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.repositories.CorretoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CorretoraService {

    private final CorretoraRepository corretoraRepository;

    public List<Corretora> findAll(){
        return corretoraRepository.findAll();
    }

}
