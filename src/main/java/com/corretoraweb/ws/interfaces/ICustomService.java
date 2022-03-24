package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.beneficiario.BeneficiarioCreateDTO;
import com.corretoraweb.ws.dtos.beneficiario.BeneficiarioUpdateDTO;
import com.corretoraweb.ws.entities.Beneficiario;

import java.util.List;
import java.util.Optional;

public interface ICustomService <T,S>{
    public T create(S sDTO);
    public T update(S sDTO);
    public Optional<T> findById(Long beneficiarioId);
    public List<T> findByClienteId(Long clienteId);
    public List<T> findAll();
}
