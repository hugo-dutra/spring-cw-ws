package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Telefone;
import com.corretoraweb.ws.services.TelefoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TelefoneController {
    private final TelefoneService telefoneService;

    private ResponseEntity<List<Telefone>> findAll(){
        List<Telefone> telefones = telefoneService.findAll();
        return telefones.size() == 0 ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(telefones);
    }

}
