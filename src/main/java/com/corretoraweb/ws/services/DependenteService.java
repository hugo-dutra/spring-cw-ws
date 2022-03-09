package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.dependente.DependenteCreateDTO;
import com.corretoraweb.ws.dtos.dependente.DependenteUpdateDTO;
import com.corretoraweb.ws.entities.Beneficiario;
import com.corretoraweb.ws.entities.Dependente;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IDependenteService;
import com.corretoraweb.ws.repositories.IBeneficiarioRepository;
import com.corretoraweb.ws.repositories.IDependenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DependenteService implements IDependenteService {
    private final IDependenteRepository iDependenteRepository;
    private final IBeneficiarioRepository iBeneficiarioRepository;

    public List<Dependente> findAll(){
        return iDependenteRepository.findAll();
    }

    @Override
    public Dependente create(DependenteCreateDTO dependenteCreateDTO) {
        Optional<Beneficiario> beneficiario = iBeneficiarioRepository.findById(dependenteCreateDTO.getBeneficiarioId());
        if(!beneficiario.isPresent()){
            throw new RegraDeNegocioException("Beneficiário não encontrado","DependenteService.create");
        }
        Dependente dependente = new Dependente();
        dependente.setNome(dependenteCreateDTO.getNome());
        dependente.setEmail(dependenteCreateDTO.getEmail());
        dependente.setCpf(dependenteCreateDTO.getCpf());
        dependente.setDataNascimento(dependenteCreateDTO.getDataNascimento());
        dependente.setBeneficiario(beneficiario.get());

        return iDependenteRepository.save(dependente);
    }

    @Override
    public Dependente update(DependenteUpdateDTO dependenteUpdateDTO) {
        Optional<Dependente> dependenteOptional = iDependenteRepository.findById(dependenteUpdateDTO.getId());
        if(!dependenteOptional.isPresent()){
            throw new RegraDeNegocioException("Dependente não encontrado","DependenteService.update");
        }
        Optional<Beneficiario> beneficiario = iBeneficiarioRepository.findById(dependenteUpdateDTO.getBeneficiarioId());
        if(!beneficiario.isPresent()){
            throw new RegraDeNegocioException("Beneficiário não encontrado","DependenteService.update");
        }
        Dependente dependente = new Dependente();
        dependente.setId(dependenteUpdateDTO.getId());
        dependente.setNome(dependenteUpdateDTO.getNome());
        dependente.setEmail(dependenteUpdateDTO.getEmail());
        dependente.setCpf(dependenteUpdateDTO.getCpf());
        dependente.setDataNascimento(dependenteUpdateDTO.getDataNascimento());
        dependente.setBeneficiario(beneficiario.get());

        return iDependenteRepository.save(dependente);
    }

    @Override
    public Optional<Dependente> findById(Long dependenteId) {
        return iDependenteRepository.findById(dependenteId);
    }

    @Override
    public List<Dependente> findByBeneficiarioId(Long beneficiarioId) {
        List<Dependente> dependentes = iDependenteRepository.findByBeneficiarioId(beneficiarioId);
        return dependentes;
    }

    @Override
    public void deleteById(Long beneficiarioId) {
        iDependenteRepository.deleteById(beneficiarioId);
    }
}
