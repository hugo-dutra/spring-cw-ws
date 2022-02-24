package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Boleto;
import com.corretoraweb.ws.interfaces.IBoletoService;
import com.corretoraweb.ws.services.BoletoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

@RestController
@RequestMapping("/boletos")
@RequiredArgsConstructor
public class BoletoController {

    private final IBoletoService iBoletoService;

    @GetMapping
    @ResponseStatus(OK)
    public ResponseEntity<List<Boleto>> findAll(){
        List<Boleto> boletos = iBoletoService.findAll();
        return boletos.size() == 0 ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(boletos);
    }

    @GetMapping("/corretora/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<List<Boleto>> findByCorretoraId(@PathVariable Long id){
        List<Boleto> boletos = iBoletoService.findByCorretoraId(id);
        return boletos.size() == 0 ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(boletos);
    }

}
