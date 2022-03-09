package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.contrato.ContratoCreateDTO;
import com.corretoraweb.ws.dtos.contrato.ContratoUpdateDTO;
import com.corretoraweb.ws.entities.Contrato;
import com.corretoraweb.ws.interfaces.IContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/contratos")
@RequiredArgsConstructor
public class ContratoController {
    private final IContratoService iContratoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Contrato> create(@RequestBody ContratoCreateDTO contratoCreateDTO){
        Contrato novoContrato = iContratoService.create(contratoCreateDTO);
        return ResponseEntity.ok(novoContrato);
    }

    @PutMapping
    @ResponseStatus(OK)
    public ResponseEntity<Contrato> update(@RequestBody ContratoUpdateDTO contratoUpdateDTO){
        Contrato contratoAlterado = iContratoService.update(contratoUpdateDTO);
        return ResponseEntity.ok(contratoAlterado);
    }

    @GetMapping("/{contratoId}")
    @ResponseStatus(OK)
    private ResponseEntity<Contrato> findById(@PathVariable Long contratoId) {
        Optional<Contrato> contrato = iContratoService.findById(contratoId);
        return contrato.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    @ResponseStatus(OK)
    private ResponseEntity<List<Contrato> > findByUsuarioId(@PathVariable Long usuarioId) {
        List<Contrato> contratos = iContratoService.findByUsuarioId(usuarioId);
        return contratos.size() != 0 ?
                ResponseEntity.ok(contratos) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/modalidadePlano/{modalidePlanoId}")
    @ResponseStatus(OK)
    private ResponseEntity<List<Contrato> > findByModalidadePlanoId(@PathVariable Long modalidePlanoId) {
        List<Contrato> contratos = iContratoService.findByModalidadePlanoId(modalidePlanoId);
        return contratos.size() != 0 ?
                ResponseEntity.ok(contratos) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/tipoContrato/{tipoContratoId}")
    @ResponseStatus(OK)
    private ResponseEntity<List<Contrato> > findByTipoContratoId(@PathVariable Long tipoContratoId) {
        List<Contrato> contratos = iContratoService.findByTipoContratoId(tipoContratoId);
        return contratos.size() != 0 ?
                ResponseEntity.ok(contratos) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/administradora/{administradoraId}")
    @ResponseStatus(OK)
    private ResponseEntity<List<Contrato> > findByAdministradoraId(@PathVariable Long administradoraId) {
        List<Contrato> contratos = iContratoService.findByAdministradoraId(administradoraId);
        return contratos.size() != 0 ?
                ResponseEntity.ok(contratos) :
                ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{contratoId}")
    @ResponseStatus(OK)
    private ResponseEntity<Void> deleteById(@PathVariable Long contratoId){
        iContratoService.deleteById(contratoId);
        return ResponseEntity.ok().build();
    }

}
