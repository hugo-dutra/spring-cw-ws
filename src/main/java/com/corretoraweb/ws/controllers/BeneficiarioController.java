package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Beneficiario;
import com.corretoraweb.ws.interfaces.IBeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {
    private final IBeneficiarioService iBeneficiarioService;

    @GetMapping
    public ResponseEntity<List<Beneficiario>>  findAll(){
        List<Beneficiario> beneficiarios = iBeneficiarioService.findAll();
        if(beneficiarios.size()==0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(beneficiarios);
    }

}
