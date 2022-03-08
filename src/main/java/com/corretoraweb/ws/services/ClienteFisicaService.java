package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.clientefisica.ClienteFisicaCreateDTO;
import com.corretoraweb.ws.dtos.clientefisica.ClienteFisicaUpdateDTO;
import com.corretoraweb.ws.entities.Cliente;
import com.corretoraweb.ws.entities.ClienteFisica;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IClienteFisicaService;
import com.corretoraweb.ws.repositories.IClienteFisicaRepository;
import com.corretoraweb.ws.repositories.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteFisicaService implements IClienteFisicaService {
    private final IClienteFisicaRepository iClienteFisicaRepository;
    private final IClienteRepository iClienteRepository;

    @Override
    public ClienteFisica create(ClienteFisicaCreateDTO clienteFisicaCreateDTO) {
        Optional<Cliente> clienteOptional = iClienteRepository.findById(clienteFisicaCreateDTO.getClienteId());
        if(!clienteOptional.isPresent()){
            throw new RegraDeNegocioException("Cliente não encontrado","ClienteFisicaService.create");
        }
        ClienteFisica clienteFisica = new ClienteFisica();
        clienteFisica.setCliente(clienteOptional.get());
        clienteFisica.setCpf(clienteFisicaCreateDTO.getCpf());
        return iClienteFisicaRepository.save(clienteFisica);
    }

    @Override
    public ClienteFisica update(ClienteFisicaUpdateDTO clienteFisicaUpdateDTO) {
        Optional<Cliente> clienteOptional = iClienteRepository.findById(clienteFisicaUpdateDTO.getClienteId());
        if(!clienteOptional.isPresent()){
            throw new RegraDeNegocioException("Cliente não encontrado","ClienteFisicaService.create");
        }
        ClienteFisica clienteFisica = new ClienteFisica();
        clienteFisica.setCliente(clienteOptional.get());
        clienteFisica.setCpf(clienteFisicaUpdateDTO.getCpf());
        clienteFisica.setId(clienteFisicaUpdateDTO.getId());
        return iClienteFisicaRepository.save(clienteFisica);
    }

    @Override
    public Optional<ClienteFisica> findById(Long clienteFisicaId) {
        return iClienteFisicaRepository.findById(clienteFisicaId);
    }

    @Override
    public List<ClienteFisica> findByClienteId(Long clienteId) {
        List<ClienteFisica> clientesFisicas = iClienteFisicaRepository.findByClienteId(clienteId);
        return clientesFisicas;
    }

    @Override
    public void delete(Long clienteFisicaId) {
        iClienteFisicaRepository.deleteById(clienteFisicaId);
    }
}
