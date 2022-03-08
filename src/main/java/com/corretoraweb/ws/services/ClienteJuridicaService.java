package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.clientejuridica.ClienteJuridicaCreateDTO;
import com.corretoraweb.ws.dtos.clientejuridica.ClienteJuridicaUpdateDTO;
import com.corretoraweb.ws.entities.Cliente;
import com.corretoraweb.ws.entities.ClienteFisica;
import com.corretoraweb.ws.entities.ClienteJuridica;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IClienteJuridicaService;
import com.corretoraweb.ws.repositories.IClienteFisicaRepository;
import com.corretoraweb.ws.repositories.IClienteJuridicaRepository;
import com.corretoraweb.ws.repositories.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteJuridicaService implements IClienteJuridicaService {
    private final IClienteJuridicaRepository iClienteJuridicaRepository;
    private final IClienteRepository iClienteRepository;
    @Override
    public ClienteJuridica create(ClienteJuridicaCreateDTO clienteJuridicaCreateDTO) {
        Optional<Cliente> clienteOptional = iClienteRepository.findById(clienteJuridicaCreateDTO.getClienteId());
        if(!clienteOptional.isPresent()){
            throw new RegraDeNegocioException("Cliente não encontrado","ClienteFisicaService.create");
        }
        ClienteJuridica clienteJuridica = new ClienteJuridica();
        clienteJuridica.setCliente(clienteOptional.get());
        clienteJuridica.setCpnj(clienteJuridicaCreateDTO.getCnpj());
        return iClienteJuridicaRepository.save(clienteJuridica);
    }

    @Override
    public ClienteJuridica update(ClienteJuridicaUpdateDTO ClienteJuridicaUpdateDTO) {
        Optional<Cliente> clienteOptional = iClienteRepository.findById(ClienteJuridicaUpdateDTO.getClienteId());
        if(!clienteOptional.isPresent()){
            throw new RegraDeNegocioException("Cliente não encontrado","ClienteFisicaService.create");
        }
        ClienteJuridica clienteJuridica = new ClienteJuridica();
        clienteJuridica.setCliente(clienteOptional.get());
        clienteJuridica.setCpnj(ClienteJuridicaUpdateDTO.getCnpj());
        clienteJuridica.setId(ClienteJuridicaUpdateDTO.getId());
        return iClienteJuridicaRepository.save(clienteJuridica);
    }

    @Override
    public Optional<ClienteJuridica> findById(Long clinenteJuridicaId) {
        return iClienteJuridicaRepository.findById(clinenteJuridicaId);
    }

    @Override
    public List<ClienteJuridica> findByClienteId(Long clienteId) {
        List<ClienteJuridica> clientesJuridicas = iClienteJuridicaRepository.findByClienteId(clienteId);
        return clientesJuridicas;
    }

    @Override
    public void delete(Long clinenteJuridicaId) {
        iClienteJuridicaRepository.deleteById(clinenteJuridicaId);
    }
}
