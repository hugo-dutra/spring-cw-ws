package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.corretora.CorretoraCreateDTO;
import com.corretoraweb.ws.dtos.corretora.CorretoraUpdateDTO;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.interfaces.ICorretoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/exists/{email}")
    @ResponseStatus(OK)
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email){
        Optional<Boolean> corretora = iCorretoraService.existsByEmail(email);
        return ResponseEntity.ok(corretora.get());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Corretora> create(@RequestBody CorretoraCreateDTO corretoraCreateDTO) {
        Corretora novaCorretora = iCorretoraService.create(corretoraCreateDTO);
        return ResponseEntity.ok(novaCorretora);
    }

    @PutMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Corretora> update(@RequestBody CorretoraUpdateDTO corretoraUpdateDTO){
        Corretora corretoraAlterada = iCorretoraService.update(corretoraUpdateDTO);
        return ResponseEntity.ok(corretoraAlterada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iCorretoraService.delete(id);
        return ResponseEntity.ok().build();
    }

}
