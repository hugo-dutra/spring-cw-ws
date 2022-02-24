package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.usuario.UsuarioCreateDTO;
import com.corretoraweb.ws.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findByCorretoraId(Long corretoraId);
    public Usuario create(UsuarioCreateDTO usuario);
    public Usuario cleanPasswordAndSalt(Usuario usuario);
}
