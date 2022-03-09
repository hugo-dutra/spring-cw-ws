package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.dependente.DependenteCreateDTO;
import com.corretoraweb.ws.dtos.dependente.DependenteUpdateDTO;
import com.corretoraweb.ws.entities.Dependente;
import com.corretoraweb.ws.interfaces.IDependenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/dependentes")
@RequiredArgsConstructor
public class DependenteController {
    private final IDependenteService iDependenteService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Dependente> create(@RequestBody DependenteCreateDTO dependenteCreateDTO){
        Dependente novoDependente = iDependenteService.create(dependenteCreateDTO);
        return ResponseEntity.ok(novoDependente);
    }

    @PutMapping
    @ResponseStatus(OK)
    public ResponseEntity<Dependente> update(@RequestBody DependenteUpdateDTO dependenteUpdateDTO){
        Dependente dependenteAlterado = iDependenteService.update(dependenteUpdateDTO);
        return ResponseEntity.ok(dependenteAlterado);
    }

    @GetMapping("/{dependenteId}")
    @ResponseStatus(OK)
    public ResponseEntity<Dependente> findById(@PathVariable Long dependenteId) {
        Optional<Dependente> dependente = iDependenteService.findById(dependenteId);
        return dependente
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/beneficiario/{beneficiarioId}")
    @ResponseStatus(OK)
    public ResponseEntity<List<Dependente>> findByBeneficiarioId(@PathVariable Long beneficiarioId) {
        List<Dependente> dependentes = iDependenteService.findByBeneficiarioId(beneficiarioId);
        return dependentes.size() != 0 ?
                ResponseEntity.ok(dependentes) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{dependenteId}")
    @ResponseStatus(OK)
    public ResponseEntity<Void> deleteById(@PathVariable Long dependenteId){
        iDependenteService.deleteById(dependenteId);
        return ResponseEntity.ok().build();
    }

}
