package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.administradora.AdministradoraCreateDTO;
import com.corretoraweb.ws.dtos.administradora.AdministradoraUpdateDTO;
import com.corretoraweb.ws.entities.Administradora;

import java.util.List;
import java.util.Optional;

public interface IAdministradoraService {
    public Administradora create(AdministradoraCreateDTO administradora);
    public Administradora update(AdministradoraUpdateDTO administradora);
    public void delete(Long administradoraId);
    public Optional<Administradora>  findById(Long administradoraId);
    public List<Administradora> findByCorretoraId(Long corretoraId);
}
