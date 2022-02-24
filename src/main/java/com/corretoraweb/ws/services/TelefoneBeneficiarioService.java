package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.TelefoneBeneficiario;
import com.corretoraweb.ws.repositories.ITelefoneBeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneBeneficiarioService {
    private final ITelefoneBeneficiarioRepository telefoneBeneficiarioRepository;

    public List<TelefoneBeneficiario> findAll(){
        return telefoneBeneficiarioRepository.findAll();
    }
}
