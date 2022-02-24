package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Beneficiario;
import com.corretoraweb.ws.interfaces.IBeneficiarioService;
import com.corretoraweb.ws.repositories.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficiarioService implements IBeneficiarioService {
    private final BeneficiarioRepository beneficiarioRepository;

    public List<Beneficiario> findAll(){
        return beneficiarioRepository.findAll();
    }
}
