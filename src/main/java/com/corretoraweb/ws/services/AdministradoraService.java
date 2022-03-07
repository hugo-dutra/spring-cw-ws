package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.administradora.AdministradoraCreateDTO;
import com.corretoraweb.ws.dtos.administradora.AdministradoraUpdateDTO;
import com.corretoraweb.ws.entities.Administradora;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IAdministradoraService;
import com.corretoraweb.ws.repositories.IAdministradoraRepository;
import com.corretoraweb.ws.repositories.ICorretoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdministradoraService implements IAdministradoraService {
    private final IAdministradoraRepository iAdministradoraRepository;
    private final ICorretoraRepository iCorretoraRepository;

    @Override
    public Administradora create(AdministradoraCreateDTO administradora) {
        Administradora novaAdministradora = new Administradora();
        Optional<Corretora> corretora = iCorretoraRepository.findById(administradora.getCorretoraId());
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","AdministradoraService.create");
        }
        novaAdministradora.setNome(administradora.getNome());
        novaAdministradora.setCorretora(corretora.get());
        iAdministradoraRepository.save(novaAdministradora);
        return novaAdministradora;
    }

    @Override
    public Administradora update(AdministradoraUpdateDTO administradora) {
        Optional<Administradora> administradoraOptional = iAdministradoraRepository.findById(administradora.getId());
        if(!administradoraOptional.isPresent()){
            throw new RegraDeNegocioException("Administradora não encontrada","AdministradoraService.update");
        }
        Optional<Corretora> corretora = iCorretoraRepository.findById(administradora.getCorretoraId());
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","AdministradoraService.update");
        }
        Administradora administradoraAlterada = new Administradora();
        administradoraAlterada.setCorretora(corretora.get());
        administradoraAlterada.setNome(administradora.getNome());
        administradoraAlterada.setId(administradora.getId());
        iAdministradoraRepository.save(administradoraAlterada);
        return administradoraAlterada;
    }

    @Override
    public void delete(Long administradoraId) {
        iAdministradoraRepository.deleteById(administradoraId);
    }

    @Override
    public Optional<Administradora> findById(Long administradoraId) {
        return iAdministradoraRepository.findById(administradoraId);
    }

    @Override
    public List<Administradora> findByCorretoraId(Long corretoraId) {
        return iAdministradoraRepository.findByCorretoraId(corretoraId);
    }
}
