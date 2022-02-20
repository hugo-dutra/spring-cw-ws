package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.cliente.ClienteCreateDTO;
import com.corretoraweb.ws.dtos.cliente.ClienteUpdateDTO;
import com.corretoraweb.ws.entities.Cliente;
import com.corretoraweb.ws.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    @ResponseStatus(OK)
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = clienteService.findAll();
        return clientes.size()==0 ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.findById(id);
        if(!cliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.get());
    }

    @GetMapping("/corretora/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<List<Cliente>> findByCorretoraId(@PathVariable Long id) {
        List<Cliente> clientes = clienteService.findByCorretoraId(id);
        return clientes.size() == 0 ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(clientes);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Cliente> create(@RequestBody ClienteCreateDTO clienteCreateDTO){
        Cliente novoCliente = clienteService.create(clienteCreateDTO);
        return ResponseEntity.ok(novoCliente);
    }

    @PutMapping
    @ResponseStatus(OK)
    public ResponseEntity<Cliente> update(@RequestBody ClienteUpdateDTO clienteUpdateDTO){
        Cliente clienteAlterado = clienteService.update(clienteUpdateDTO);
        return ResponseEntity.ok(clienteAlterado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
