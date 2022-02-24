package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.entities.Corretora;

import java.util.List;
import java.util.Optional;

public interface ICorretoraService {
    public Corretora create(Corretora corretora);
    public List<Corretora> findAll();
    public Corretora update(Corretora corretora);
    public void delete(Long id);
    public Optional<Corretora> findById(Long corretoraId);
}
