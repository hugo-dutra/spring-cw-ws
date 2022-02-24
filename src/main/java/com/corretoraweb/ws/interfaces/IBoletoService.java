package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.entities.Boleto;

import java.util.List;

public interface IBoletoService {
    public List<Boleto> findAll();
    public List<Boleto> findByCorretoraId(Long id);
}
