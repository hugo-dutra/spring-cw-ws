package com.corretoraweb.ws.services;

import com.corretoraweb.ws.entities.Boleto;
import com.corretoraweb.ws.interfaces.IBoletoService;
import com.corretoraweb.ws.repositories.IBoletoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoletoService implements IBoletoService {

    private IBoletoRepository iBoletoRepository;

    public List<Boleto> findAll(){
        return iBoletoRepository.findAll();
    }
    public List<Boleto> findByCorretoraId(Long id){
        return iBoletoRepository.findByCorretoraId(id);
    }

}
