package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.ClienteCreateDTO;
import com.corretoraweb.ws.entities.Cliente;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.repositories.ClienteRepository;
import com.corretoraweb.ws.repositories.CorretoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final CorretoraRepository corretoraRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente save(ClienteCreateDTO clienteCreateDTO){
        Cliente novoCliente = new Cliente();
        Optional<Corretora>  corretora = corretoraRepository.findById(clienteCreateDTO.getCorretora());
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada");
        }
        novoCliente.setCep(clienteCreateDTO.getCep());
        novoCliente.setEndereco(clienteCreateDTO.getEndereco());
        novoCliente.setCidade(clienteCreateDTO.getCidade());
        novoCliente.setUf(clienteCreateDTO.getUf());
        novoCliente.setEmail(clienteCreateDTO.getEmail());
        novoCliente.setNome(clienteCreateDTO.getNome());
        novoCliente.setCpfCnpj(clienteCreateDTO.getCpfCnpj());
        novoCliente.setPessoaFisica(clienteCreateDTO.getPessoaFisica());
        novoCliente.setCorretora(corretora.get());
        return clienteRepository.save(novoCliente);
    }


}
