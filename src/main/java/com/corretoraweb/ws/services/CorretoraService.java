package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.corretora.CorretoraCreateDTO;
import com.corretoraweb.ws.dtos.corretora.CorretoraUpdateDTO;
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

    public Corretora create(CorretoraCreateDTO corretoraCreateDTO) {
        Corretora novaCorretora = new Corretora();
        novaCorretora.setNome(corretoraCreateDTO.getNome());
        novaCorretora.setEmail(corretoraCreateDTO.getEmail());
        novaCorretora.setTelefone(corretoraCreateDTO.getTelefone());
        return iCorretoraRepository.save(novaCorretora);
    }

    public List<Corretora> findAll() {
        return iCorretoraRepository.findAll();
    }

    public Corretora update(CorretoraUpdateDTO corretoraUpdateDTO){
        Optional<Corretora> corretoraOptional = iCorretoraRepository.findById(corretoraUpdateDTO.getId());
        if(!corretoraOptional.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.update");
        }
        Corretora corretoraAlterada = corretoraOptional.get();
        corretoraAlterada.setId(corretoraUpdateDTO.getId());
        corretoraAlterada.setEmail(corretoraUpdateDTO.getEmail());
        corretoraAlterada.setNome(corretoraUpdateDTO.getNome());
        corretoraAlterada.setTelefone(corretoraUpdateDTO.getTelefone());
        return iCorretoraRepository.save(corretoraAlterada);
    }

    public void delete(Long id){
        Optional<Corretora> corretoraOptional = iCorretoraRepository.findById(id);
        if(!corretoraOptional.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.delete");
        }
        iCorretoraRepository.deleteById(id);
    }

    public Optional<Boolean> existsByEmail(String email){
        return iCorretoraRepository.existsByEmail(email);
    }

    @Override
    public Optional<Corretora>  findById(Long corretoraId) {
        Optional<Corretora> corretora = iCorretoraRepository.findById(corretoraId);
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","CorretoraService.findById");
        }
        return corretora;
    }

}
