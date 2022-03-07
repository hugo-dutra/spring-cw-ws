package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.clientefisica.ClienteFisicaCreateDTO;
import com.corretoraweb.ws.dtos.clientefisica.ClienteFisicaUpdateDTO;
import com.corretoraweb.ws.entities.ClienteFisica;
import com.corretoraweb.ws.interfaces.IClienteFisicaService;
import com.corretoraweb.ws.repositories.IClienteFisicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteFisicaService implements IClienteFisicaService {
    private final IClienteFisicaRepository iClienteFisicaRepository;

    @Override
    public ClienteFisica create(ClienteFisicaCreateDTO clienteFisicaCreateDTO) {
        return null;
    }

    @Override
    public ClienteFisica update(ClienteFisicaUpdateDTO clienteFisicaUpdateDTO) {
        return null;
    }

    @Override
    public Optional<ClienteFisica> findById(Long ClinenteFisicaId) {
        return Optional.empty();
    }

    @Override
    public List<ClienteFisica> findByCorretoraId(Long corretoraId) {
        return null;
    }

    @Override
    public void delete(Long clienteFisicaId) {

    }
}
