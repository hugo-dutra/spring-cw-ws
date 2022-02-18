package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Boleto;
import com.corretoraweb.ws.repositories.BoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoletoService {

    private BoletoRepository boletoRepository;

    public List<Boleto> findAll(){
        return boletoRepository.findAll();
    }

}
