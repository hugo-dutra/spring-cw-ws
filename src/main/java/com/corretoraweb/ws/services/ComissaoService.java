package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.comissao.ComissaoCreateDTO;
import com.corretoraweb.ws.dtos.comissao.ComissaoUpdateDTO;
import com.corretoraweb.ws.entities.*;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IComissaoService;
import com.corretoraweb.ws.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComissaoService implements IComissaoService {
    private final IComissaoRepository iComissaoRepository;
    private final ITipoComissaoRepository iTipoComissaoRepository;
    private final ITipoPagamentoRepository iTipoPagamentoRepository;
    private final IContratoRepository iContratoRepository;

    @Override
    public Comissao create(ComissaoCreateDTO comissaoCreateDTO) {
        Optional<TipoComissao> tipoComissao = iTipoComissaoRepository.findById(comissaoCreateDTO.getTipoComissaoId());
        if(!tipoComissao.isPresent()){
            throw new RegraDeNegocioException("Tipo de comissão não encontrada","ComissaoService.create");
        }
        Optional<TipoPagamento> tipoPagamento = iTipoPagamentoRepository.findById(comissaoCreateDTO.getTipoPagementoId());
        if(!tipoPagamento.isPresent()){
            throw new RegraDeNegocioException("Tipo de pagamento não encontrado","ComissaoService.create");
        }
        Optional<Contrato> contrato = iContratoRepository.findById(comissaoCreateDTO.getContratoId());
        if(!contrato.isPresent()){
            throw new RegraDeNegocioException("Contrato não encontrado","ComissaoService.create");
        }
        Comissao novaComissao = new Comissao();
        novaComissao.setTipoComissao(tipoComissao.get());
        novaComissao.setContrato(contrato.get());
        novaComissao.setTipoPagamento(tipoPagamento.get());
        novaComissao.setNome(comissaoCreateDTO.getNome());
        return iComissaoRepository.save(novaComissao);
    }

    @Override
    public Comissao update(ComissaoUpdateDTO comissaoUpdateDTO) {
        Optional<TipoComissao> tipoComissao = iTipoComissaoRepository.findById(comissaoUpdateDTO.getTipoComissaoId());
        if(!tipoComissao.isPresent()){
            throw new RegraDeNegocioException("Tipo de comissão não encontrada","ComissaoService.create");
        }
        Optional<TipoPagamento> tipoPagamento = iTipoPagamentoRepository.findById(comissaoUpdateDTO.getTipoPagementoId());
        if(!tipoPagamento.isPresent()){
            throw new RegraDeNegocioException("Tipo de pagamento não encontrado","ComissaoService.create");
        }
        Optional<Contrato> contrato = iContratoRepository.findById(comissaoUpdateDTO.getContratoId());
        if(!contrato.isPresent()){
            throw new RegraDeNegocioException("Contrato não encontrado","ComissaoService.create");
        }
        Comissao comissaoAlterada = new Comissao();
        comissaoAlterada.setId(comissaoUpdateDTO.getId());
        comissaoAlterada.setTipoComissao(tipoComissao.get());
        comissaoAlterada.setContrato(contrato.get());
        comissaoAlterada.setTipoPagamento(tipoPagamento.get());
        comissaoAlterada.setNome(comissaoAlterada.getNome());
        return iComissaoRepository.save(comissaoAlterada);
    }

    @Override
    public void delete(Long comissaoId) {
        iComissaoRepository.deleteById(comissaoId);
    }

    @Override
    public Optional<Comissao> findById(Long comissaoId) {
        return iComissaoRepository.findById(comissaoId);
    }

    @Override
    public List<Comissao> findByContratoId(Long contratoId) {
        return iComissaoRepository.findByContratoId(contratoId);
    }
}
