package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.perfil.PerfilCreateDTO;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.entities.Perfil;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.ICorretoraService;
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
    private final ICorretoraService iCorretoraService;

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

    @Override
    public Perfil create(PerfilCreateDTO perfilCreateDTO) {
        Perfil perfil = new Perfil();
        perfil.setNome(perfilCreateDTO.getNome());
        Optional<Corretora> corretora = iCorretoraService.findById((perfilCreateDTO.getCorretoraId()));
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","PerfilService.create");
        }
        perfil.setCorretora(corretora.get());
        return iPerfilRepository.save(perfil);
    }
}
