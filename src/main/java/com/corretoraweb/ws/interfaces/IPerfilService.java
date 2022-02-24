package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.entities.Perfil;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IPerfilService {
    public Optional<Perfil> findById(Long perfilId);
    public List<Perfil> findByCorretoraId(Long corretoraId);
}
