package com.corretoraweb.ws.controllers;

import com.corretoraweb.ws.dtos.comissao.ComissaoCreateDTO;
import com.corretoraweb.ws.dtos.comissao.ComissaoUpdateDTO;
import com.corretoraweb.ws.entities.Comissao;
import com.corretoraweb.ws.interfaces.IComissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/comissoes")
@RequiredArgsConstructor
public class ComissaoController {
    public static IComissaoService iComissaoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<Comissao> create(@RequestBody ComissaoCreateDTO comissaoCreateDTO) {
        Comissao novaComissao = iComissaoService.create(comissaoCreateDTO);
        return ResponseEntity.ok(novaComissao);
    }

    @PutMapping
    @ResponseStatus(OK)
    public ResponseEntity<Comissao> update(@RequestBody ComissaoUpdateDTO comissaoUpdateDTO){
        Comissao comissaoAlterada = iComissaoService.update(comissaoUpdateDTO);
        return ResponseEntity.ok(comissaoAlterada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<Void> delete(@PathVariable Long comissaoId){
        iComissaoService.delete(comissaoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{comissaoId}")
    public ResponseEntity<Comissao> findById(@PathVariable Long comissaoId) {
        Optional<Comissao> comissao = iComissaoService.findById(comissaoId);
        return comissao.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/contrato/{contratoId}")
    public ResponseEntity<List<Comissao>> findByContratoId(@PathVariable Long contratoId) {
        List<Comissao> comissao = iComissaoService.findByContratoId(contratoId);
        return comissao.size() == 0 ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(comissao);
    }

}
