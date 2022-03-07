package com.corretoraweb.ws.controllers;


import com.corretoraweb.ws.dtos.administradora.AdministradoraCreateDTO;
import com.corretoraweb.ws.dtos.administradora.AdministradoraUpdateDTO;
import com.corretoraweb.ws.entities.Administradora;
import com.corretoraweb.ws.interfaces.IAdministradoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/administradoras")
@RequiredArgsConstructor
public class AdministradoraController {
    private final IAdministradoraService iAdministradoraService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Administradora> create(@RequestBody AdministradoraCreateDTO administradoraCreateDTO){
        Administradora administradora =  iAdministradoraService.create(administradoraCreateDTO);
        return ResponseEntity.ok(administradora);
    }

    @GetMapping("/corretora/{corretoraId}")
    public ResponseEntity<List<Administradora>> findByCorretoraId(@PathVariable Long corretoraId) {
        List<Administradora> administradoras = iAdministradoraService.findByCorretoraId(corretoraId);
        return (administradoras.size() == 0) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(administradoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administradora> findById(@PathVariable Long id) {
        Optional<Administradora> administradora = iAdministradoraService.findById(id);
        return (!administradora.isPresent()) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(administradora.get());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iAdministradoraService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    @ResponseStatus(OK)
    public ResponseEntity<Administradora> update(@RequestBody AdministradoraUpdateDTO administradoraUpdateDTO){
        Administradora administradoraAlterada = iAdministradoraService.update(administradoraUpdateDTO);
        return ResponseEntity.ok(administradoraAlterada);
    }






}
