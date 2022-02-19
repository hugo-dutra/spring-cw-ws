package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.services.CorretoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corretoras")
@RequiredArgsConstructor
public class CorretoraController {

    private final CorretoraService corretoraService;

    @GetMapping
    public ResponseEntity<List<Corretora>> findAll(){
        List<Corretora> corretoras =  corretoraService.findAll();
        return corretoras.size() == 0 ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(corretoras);
    }

    @PostMapping
    public ResponseEntity<Corretora> create(@RequestBody Corretora corretora) {
        Corretora novaCorretora = corretoraService.create(corretora);
        return ResponseEntity.ok(novaCorretora);
    }

    @PutMapping
    public ResponseEntity<Corretora> update(@RequestBody Corretora corretora){
        Corretora corretoraAlterada = corretoraService.update(corretora);
        return ResponseEntity.ok(corretoraAlterada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        corretoraService.delete(id);
        return ResponseEntity.ok().build();
    }

}
