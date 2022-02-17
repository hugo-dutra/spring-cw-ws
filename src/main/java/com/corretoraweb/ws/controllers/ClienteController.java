package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Cliente;
import com.corretoraweb.ws.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.save(cliente);
        return ResponseEntity.ok(novoCliente);
    }

}
