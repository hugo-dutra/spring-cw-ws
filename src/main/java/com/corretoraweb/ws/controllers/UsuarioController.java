package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.usuario.UsuarioCreateDTO;
import com.corretoraweb.ws.entities.Usuario;
import com.corretoraweb.ws.interfaces.ICypher;
import com.corretoraweb.ws.interfaces.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final IUsuarioService iUsuarioService;

    @GetMapping("/corretora/{corretoraId}")
    public ResponseEntity<List<Usuario>> findByCorretoraId(@PathVariable Long corretoraId) {
        List<Usuario> usuarios = iUsuarioService.findByCorretoraId(corretoraId);
        return (usuarios.size() == 0) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioCreateDTO usuario){
        Usuario novoUsuario = iUsuarioService.create(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

}
