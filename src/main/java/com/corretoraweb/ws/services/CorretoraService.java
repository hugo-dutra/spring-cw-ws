package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.ICorretoraService;
import com.corretoraweb.ws.repositories.CorretoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorretoraService implements ICorretoraService {

    private final CorretoraRepository corretoraRepository;

    public Corretora create(Corretora corretora) {
        return corretoraRepository.save(corretora);
    }

    public List<Corretora> findAll() {
        return corretoraRepository.findAll();
    }

    public Corretora update(Corretora corretora){
        Optional<Corretora> corretoraOptional = corretoraRepository.findById(corretora.getId());
        if(!corretoraOptional.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.update");
        }
        Corretora corretoraAlterada = corretoraOptional.get();
        corretoraAlterada.setEmail(corretora.getEmail());
        corretoraAlterada.setNome(corretora.getNome());
        corretoraAlterada.setTelefone(corretora.getTelefone());
        return corretoraRepository.save(corretoraAlterada);
    }

    public void delete(Long id){
        Optional<Corretora> corretoraOptional = corretoraRepository.findById(id);
        if(!corretoraOptional.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.delete");
        }
        corretoraRepository.deleteById(id);
    }

    @Override
    public Corretora findById(Long corretoraId) {
        Optional<Corretora> corretora = corretoraRepository.findById(corretoraId);
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.findById");
        }
        return corretora.get();
    }

}
