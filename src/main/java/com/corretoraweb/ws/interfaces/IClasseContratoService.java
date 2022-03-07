package com.corretoraweb.ws.interfaces;


import com.corretoraweb.ws.dtos.classecontrato.ClasseContratoCreateDTO;
import com.corretoraweb.ws.dtos.classecontrato.ClasseContratoUpdateDTO;
import com.corretoraweb.ws.entities.ClasseContrato;

import java.util.List;
import java.util.Optional;

public interface IClasseContratoService {
    public ClasseContrato create (ClasseContratoCreateDTO classeContratoCreateDTO);
    public ClasseContrato update (ClasseContratoUpdateDTO classeContratoUpdateDTO);
    public void delete(Long classeContratoId);
    public Optional<ClasseContrato> findById(Long classeContratoId);
    public List<ClasseContrato> findByCorretoraId(Long corretoraId);
}
