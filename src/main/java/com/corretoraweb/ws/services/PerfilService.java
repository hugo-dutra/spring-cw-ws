package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Perfil;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IPerfilService;
import com.corretoraweb.ws.repositories.IPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerfilService implements IPerfilService {
    private final IPerfilRepository perfilRepository;

    @Override
    public Perfil findById(Long perfilId) {
        Optional<Perfil> perfil = perfilRepository.findById(perfilId);
        if(!perfil.isPresent()){
            throw new RegraDeNegocioException("Perfil não encontrado","PerfilService.findById");
        }
        return perfil.get();
    }
}
