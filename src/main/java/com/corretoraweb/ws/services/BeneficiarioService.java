package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Beneficiario;
import com.corretoraweb.ws.interfaces.IBeneficiarioService;
import com.corretoraweb.ws.repositories.IBeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficiarioService implements IBeneficiarioService {
    private final IBeneficiarioRepository iBeneficiarioRepository;

    public List<Beneficiario> findAll(){
        return iBeneficiarioRepository.findAll();
    }
}
