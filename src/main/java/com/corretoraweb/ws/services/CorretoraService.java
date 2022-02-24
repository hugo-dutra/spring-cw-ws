package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.ICorretoraService;
import com.corretoraweb.ws.repositories.ICorretoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorretoraService implements ICorretoraService {

    private final ICorretoraRepository iCorretoraRepository;

    public Corretora create(Corretora corretora) {
        return iCorretoraRepository.save(corretora);
    }

    public List<Corretora> findAll() {
        return iCorretoraRepository.findAll();
    }

    public Corretora update(Corretora corretora){
        Optional<Corretora> corretoraOptional = iCorretoraRepository.findById(corretora.getId());
        if(!corretoraOptional.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.update");
        }
        Corretora corretoraAlterada = corretoraOptional.get();
        corretoraAlterada.setEmail(corretora.getEmail());
        corretoraAlterada.setNome(corretora.getNome());
        corretoraAlterada.setTelefone(corretora.getTelefone());
        return iCorretoraRepository.save(corretoraAlterada);
    }

    public void delete(Long id){
        Optional<Corretora> corretoraOptional = iCorretoraRepository.findById(id);
        if(!corretoraOptional.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.delete");
        }
        iCorretoraRepository.deleteById(id);
    }

    @Override
    public Corretora findById(Long corretoraId) {
        Optional<Corretora> corretora = iCorretoraRepository.findById(corretoraId);
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.findById");
        }
        return corretora.get();
    }

}
