package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.usuario.UsuarioCreateDTO;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.entities.Perfil;
import com.corretoraweb.ws.entities.Usuario;
import com.corretoraweb.ws.interfaces.ICorretoraService;
import com.corretoraweb.ws.interfaces.ICypher;
import com.corretoraweb.ws.interfaces.IPerfilService;
import com.corretoraweb.ws.interfaces.IUsuarioService;
import com.corretoraweb.ws.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ICypher iCypher;
    private final ICorretoraService iCorretoraService;
    private final IPerfilService iPerfilService;

    @Override
    public List<Usuario> findByCorretoraId(Long corretoraId){
        List<Usuario> usuarios = usuarioRepository.findByCorretoraId(corretoraId);
        return usuarios;
    }

    @Override
    public Usuario create(UsuarioCreateDTO usuario) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(iCypher.getPasswordEncoder().encode(usuario.getSenha()));
        Corretora corretora = iCorretoraService.findById(usuario.getCorretoraId());
        novoUsuario.setCorretora(corretora);
        Perfil perfil = iPerfilService.findById(usuario.getPerfilId());
        novoUsuario.setPerfil(perfil);
        return cleanPasswordAndSalt(usuarioRepository.save(novoUsuario));
    }

    @Override
    public Usuario cleanPasswordAndSalt(Usuario usuario) {
        Usuario cleanUsuario = usuario;
        cleanUsuario.setSalt("");
        cleanUsuario.setSenha("");
        return cleanUsuario;
    }


}
