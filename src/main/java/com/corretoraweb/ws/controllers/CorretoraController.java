package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.interfaces.ICorretoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/corretoras")
@RequiredArgsConstructor
public class CorretoraController {

    private final ICorretoraService iCorretoraService;

    @GetMapping
    @ResponseStatus(OK)
    public ResponseEntity<List<Corretora>> findAll(){
        List<Corretora> corretoras =  iCorretoraService.findAll();
        return corretoras.size() == 0 ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(corretoras);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Corretora> create(@RequestBody Corretora corretora) {
        Corretora novaCorretora = iCorretoraService.create(corretora);
        return ResponseEntity.ok(novaCorretora);
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Corretora> update(@RequestBody Corretora corretora){
        Corretora corretoraAlterada = iCorretoraService.update(corretora);
        return ResponseEntity.ok(corretoraAlterada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iCorretoraService.delete(id);
        return ResponseEntity.ok().build();
    }

}
