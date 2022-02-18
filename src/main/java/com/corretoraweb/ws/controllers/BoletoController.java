package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Boleto;
import com.corretoraweb.ws.services.BoletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boletos")
@RequiredArgsConstructor
public class BoletoController {

    private final BoletoService boletoService;

    @GetMapping
    public ResponseEntity<List<Boleto>> findAll(){
        List<Boleto> boletos = boletoService.findAll();
        return boletos.size() == 0 ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(boletos);
    }



}
