package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.perfil.PerfilCreateDTO;
import com.corretoraweb.ws.entities.Perfil;
import com.corretoraweb.ws.interfaces.IPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("perfis")
@RequiredArgsConstructor
public class PerfilController {
    private final IPerfilService iPerfilService;

    @GetMapping("corretora/{corretoraId}")
    @ResponseStatus(OK)
    public ResponseEntity<List<Perfil>> findByCorretoraId(@PathVariable Long corretoraId) {
        List<Perfil> perfis = iPerfilService.findByCorretoraId(corretoraId);
        return (perfis.size() == 0) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(perfis);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<Perfil> findById(@PathVariable Long id) {
        Optional<Perfil> perfil = iPerfilService.findById(id);
        return (!perfil.isPresent()) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(perfil.get());

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Perfil> crate(@RequestBody PerfilCreateDTO perfilCreateDTO){
        Perfil perfil = iPerfilService.create(perfilCreateDTO);
        return ResponseEntity.ok(perfil);
    }


}
