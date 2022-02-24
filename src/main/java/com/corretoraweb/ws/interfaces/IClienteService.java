package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.cliente.ClienteCreateDTO;
import com.corretoraweb.ws.dtos.cliente.ClienteUpdateDTO;
import com.corretoraweb.ws.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public Cliente create(ClienteCreateDTO clienteCreateDTO);
    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public List<Cliente>  findByCorretoraId(Long id);
    public List<Cliente>  filterCliente(Cliente cliente);
    public Cliente update(ClienteUpdateDTO clienteUpdateDTO);
    public void delete(Long id);
}
