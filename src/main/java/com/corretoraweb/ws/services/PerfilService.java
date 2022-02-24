package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Perfil;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IPerfilService;
import com.corretoraweb.ws.repositories.IPerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerfilService implements IPerfilService {
    private final IPerfilRepository iPerfilRepository;

    @Override
    public Optional<Perfil> findById(Long perfilId) {
        Optional<Perfil> perfil = iPerfilRepository.findById(perfilId);
        if(!perfil.isPresent()){
            throw new RegraDeNegocioException("Perfil não encontrado","PerfilService.findById");
        }
        return perfil;
    }

    @Override
    public List<Perfil> findByCorretoraId(Long corretoraId) {
        List<Perfil> perfis = iPerfilRepository.findByCorretoraId(corretoraId);
        if(perfis.size()==0){
            throw new RegraDeNegocioException("Perfil não encontrado","PerfilService.findByCorretoraId");
        }
        return perfis;
    }
}
