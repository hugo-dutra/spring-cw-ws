package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.dtos.comissao.ComissaoCreateDTO;
import com.corretoraweb.ws.dtos.comissao.ComissaoUpdateDTO;
import com.corretoraweb.ws.entities.Comissao;

import java.util.List;
import java.util.Optional;

public interface IComissaoService {
    public Comissao create (ComissaoCreateDTO comissaoCreateDTO);
    public Comissao update (ComissaoUpdateDTO comissaoUpdateDTO);
    public void delete(Long comissaoId);
    public Optional<Comissao> findById(Long comissaoId);
    public List<Comissao> findByContratoId(Long contratoId);

}
