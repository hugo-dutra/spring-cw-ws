package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Perfil;
import com.corretoraweb.ws.interfaces.IPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("perfis")
@RequiredArgsConstructor
public class PerfilController {
    private final IPerfilService iPerfilService;

    @GetMapping("corretora/{corretoraId}")
    public ResponseEntity<List<Perfil>> findByCorretoraId(@PathVariable Long corretoraId) {
        List<Perfil> perfis = iPerfilService.findByCorretoraId(corretoraId);
        return (perfis.size() == 0) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(perfis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> findById(@PathVariable Long id) {
        Optional<Perfil> perfil = iPerfilService.findById(id);
        return (!perfil.isPresent()) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(perfil.get());

    }


}
