package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.cliente.ClienteCreateDTO;
import com.corretoraweb.ws.dtos.cliente.ClienteUpdateDTO;
import com.corretoraweb.ws.entities.Cliente;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IClienteService;
import com.corretoraweb.ws.repositories.IClienteRepository;
import com.corretoraweb.ws.repositories.ICorretoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final IClienteRepository iClienteRepository;
    private final ICorretoraRepository iCorretoraRepository;

    public Cliente create(ClienteCreateDTO clienteCreateDTO){
        Cliente novoCliente = new Cliente();
        Optional<Corretora>  corretora = iCorretoraRepository.findById(clienteCreateDTO.getCorretora());
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Cliente não encontrado","ClienteService.Create");
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
        return iClienteRepository.save(novoCliente);
    }

    public List<Cliente> findAll(){
        return iClienteRepository.findAll();
    }

    public Optional<Cliente>  findById(Long id){
        return iClienteRepository.findById(id);
    }

    public List<Cliente>  findByCorretoraId(Long id){
        return iClienteRepository.findByCorretoraId(id);
    }

    public List<Cliente>  filterCliente(Cliente cliente){
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Cliente> clienteExample = Example.of(cliente,exampleMatcher);
        List<Cliente> clientes = iClienteRepository.findAll(clienteExample);
        return clientes;
    }

    public Cliente update(ClienteUpdateDTO clienteUpdateDTO){
        Optional<Cliente>  cliente = iClienteRepository.findById(clienteUpdateDTO.getId());
        if(!cliente.isPresent()){
            throw new RegraDeNegocioException("Cliente não encontrada","ClienteService.update");
        }
        Cliente clienteAlterado = cliente.get();
        clienteAlterado.setCep(clienteUpdateDTO.getCep());
        clienteAlterado.setEndereco(clienteUpdateDTO.getEndereco());
        clienteAlterado.setCidade(clienteUpdateDTO.getCidade());
        clienteAlterado.setUf(clienteUpdateDTO.getUf());
        clienteAlterado.setEmail(clienteUpdateDTO.getEmail());
        clienteAlterado.setNome(clienteUpdateDTO.getNome());
        clienteAlterado.setCpfCnpj(clienteUpdateDTO.getCpfCnpj());
        clienteAlterado.setPessoaFisica(clienteUpdateDTO.getPessoaFisica());
        clienteAlterado.setId(clienteAlterado.getId());
        return iClienteRepository.save(clienteAlterado);
    }

    public void delete(Long id){
        Optional<Cliente>  cliente = iClienteRepository.findById(id);
        if(!cliente.isPresent()){
            throw new RegraDeNegocioException("Cliente não encontrado","ClienteService.delete");
        }
        iClienteRepository.deleteById(id);
    }


}
