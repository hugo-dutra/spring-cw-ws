package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.clientefisica.ClienteFisicaCreateDTO;
import com.corretoraweb.ws.dtos.clientefisica.ClienteFisicaUpdateDTO;
import com.corretoraweb.ws.entities.ClienteFisica;

import java.util.List;
import java.util.Optional;

public interface IClienteFisicaService {
    public ClienteFisica create(ClienteFisicaCreateDTO clienteFisicaCreateDTO);
    public ClienteFisica update(ClienteFisicaUpdateDTO clienteFisicaUpdateDTO);
    public Optional<ClienteFisica> findById(Long ClinenteFisicaId);
    public List<ClienteFisica> findByCorretoraId(Long corretoraId);
    public void delete(Long clienteFisicaId);
}
