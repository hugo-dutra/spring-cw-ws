package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.classecontrato.ClasseContratoCreateDTO;
import com.corretoraweb.ws.dtos.classecontrato.ClasseContratoUpdateDTO;
import com.corretoraweb.ws.entities.ClasseContrato;
import com.corretoraweb.ws.interfaces.IClasseContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/classes-contratos")
@RequiredArgsConstructor
public class ClasseContratoController {
    private final IClasseContratoService iClasseContratoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<ClasseContrato>  create(@RequestBody ClasseContratoCreateDTO classeContratoCreateDTO) {
        ClasseContrato classeContrato = iClasseContratoService.create(classeContratoCreateDTO);
        return ResponseEntity.ok(classeContrato);
    }

    @GetMapping("/classeContratoId")
    @ResponseStatus(OK)
    public ResponseEntity<ClasseContrato> findById(@PathVariable Long classeContratoId) {
        Optional<ClasseContrato> classeContrato = iClasseContratoService.findById(classeContratoId);
        return (!classeContrato.isPresent()) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(classeContrato.get());
    }

    @GetMapping("/corretora/{corretoraId}")
    @ResponseStatus(OK)
    public ResponseEntity<List<ClasseContrato>> findByCorretoraId(@PathVariable Long corretoraId) {
        List<ClasseContrato> classesContratos = iClasseContratoService.findByCorretoraId(corretoraId);
        return (classesContratos.size() != 0) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(classesContratos);
    }

    @PutMapping
    @ResponseStatus(OK)
    public ResponseEntity<ClasseContrato> update(@RequestBody ClasseContratoUpdateDTO classeContratoUpdateDTO){
        ClasseContrato classeContratoAlterada = iClasseContratoService.update(classeContratoUpdateDTO);
        return ResponseEntity.ok(classeContratoAlterada);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iClasseContratoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
