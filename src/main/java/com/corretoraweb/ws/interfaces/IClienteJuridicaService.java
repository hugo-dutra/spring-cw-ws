package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.clientejuridica.ClienteJuridicaCreateDTO;
import com.corretoraweb.ws.dtos.clientejuridica.ClienteJuridicaUpdateDTO;
import com.corretoraweb.ws.entities.ClienteJuridica;

import java.util.List;
import java.util.Optional;

public interface IClienteJuridicaService {
    public ClienteJuridica create(ClienteJuridicaCreateDTO clienteJuridicaCreateDTO);
    public ClienteJuridica update(ClienteJuridicaUpdateDTO clienteJuridicaUpdateDTO);
    public Optional<ClienteJuridica> findById(Long clinenteJuridicaId);
    public List<ClienteJuridica> findByClienteId(Long clienteId);
    public void delete(Long clinenteJuridicaId);
}
