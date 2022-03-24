package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.corretora.CorretoraCreateDTO;
import com.corretoraweb.ws.dtos.corretora.CorretoraUpdateDTO;
import com.corretoraweb.ws.entities.Corretora;

import java.util.List;
import java.util.Optional;

public interface ICorretoraService {
    public Corretora create(CorretoraCreateDTO corretora);
    public Corretora update(CorretoraUpdateDTO corretora);
    public List<Corretora> findAll();
    public void delete(Long id);
    public Optional<Corretora> findById(Long corretoraId);
    public Optional<Boolean> existsByEmail(String email);
}
