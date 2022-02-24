package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.entities.Corretora;

import java.util.List;

public interface ICorretoraService {
    public Corretora create(Corretora corretora);
    public List<Corretora> findAll();
    public Corretora update(Corretora corretora);
    public void delete(Long id);
    public Corretora findById(Long corretoraId);
}
