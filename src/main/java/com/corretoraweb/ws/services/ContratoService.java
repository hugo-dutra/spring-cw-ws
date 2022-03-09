package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.contrato.ContratoCreateDTO;
import com.corretoraweb.ws.dtos.contrato.ContratoUpdateDTO;
import com.corretoraweb.ws.entities.*;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IContratoService;
import com.corretoraweb.ws.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratoService implements IContratoService {
    private final IContratoRepository iContratoRepository;
    private final IUsuarioRepository iUsuarioRepository;
    private final IModalidadePlanoRepository iModalidadePlanoRepository;
    private final ITipoContratoRepository iTipoContratoRepository;
    private final IClasseContratoRepository iClasseContratoRepository;
    private final IAdministradoraRepository iAdministradoraRepository;

    @Override
    public Contrato create(ContratoCreateDTO contratoCreateDTO) {
        Optional<Usuario> usuario = iUsuarioRepository.findById(contratoCreateDTO.getUsuarioId());
        if(!usuario.isPresent()){
            throw new RegraDeNegocioException("Usuário não encontrado","ContratoService.create");
        }
        Optional<ModalidadePlano> modalidadePlano = iModalidadePlanoRepository.findById(contratoCreateDTO.getModalidadePlanoId());
        if(!modalidadePlano.isPresent()){
            throw new RegraDeNegocioException("Modalide de plano não encontrada","ContratoService.create");
        }
        Optional<TipoContrato> tipoContrato = iTipoContratoRepository.findById(contratoCreateDTO.getTipoContratoId());
        if(!tipoContrato.isPresent()){
            throw new RegraDeNegocioException("Tipo de contrato não encontrado","ContratoService.create");
        }
        Optional<ClasseContrato> classeContrato = iClasseContratoRepository.findById(contratoCreateDTO.getClasseContratoId());
        if(!classeContrato.isPresent()){
            throw new RegraDeNegocioException("Classe de contrato não encontrado","ContratoService.create");
        }
        Optional<Administradora> administradora = iAdministradoraRepository.findById(contratoCreateDTO.getAdministradoraId());
        if(!administradora.isPresent()){
            throw new RegraDeNegocioException("Administradora não encontrada","ContratoService.create");
        }

        Contrato contrato = new Contrato();
        contrato.setValor(contratoCreateDTO.getValor());
        contrato.setNumeroContrato(contratoCreateDTO.getNumeroContrato());
        contrato.setInicioVigencia(contratoCreateDTO.getInicioVigencia());
        contrato.setValorDesconto(contratoCreateDTO.getValorDesconto());
        contrato.setDataAssinaturaContrato(contratoCreateDTO.getDataAssinaturaContrato());
        contrato.setUsuario(usuario.get());
        contrato.setModalidadePlano(modalidadePlano.get());
        contrato.setTipoContrato(tipoContrato.get());
        contrato.setClasseContrato(classeContrato.get());
        contrato.setAdministradora(administradora.get());

        return iContratoRepository.save(contrato);
    }

    @Override
    public Contrato update(ContratoUpdateDTO contratoUpdateDTO) {
        Optional<Contrato> contratoOptional = iContratoRepository.findById(contratoUpdateDTO.getId());
        if(!contratoOptional.isPresent()){
            throw new RegraDeNegocioException("Contrato não encontrado","ContratoService.create");
        }
        Optional<Usuario> usuario = iUsuarioRepository.findById(contratoUpdateDTO.getUsuarioId());
        if(!usuario.isPresent()){
            throw new RegraDeNegocioException("Usuário não encontrado","ContratoService.create");
        }
        Optional<ModalidadePlano> modalidadePlano = iModalidadePlanoRepository.findById(contratoUpdateDTO.getModalidadePlanoId());
        if(!modalidadePlano.isPresent()){
            throw new RegraDeNegocioException("Modalide de plano não encontrada","ContratoService.create");
        }
        Optional<TipoContrato> tipoContrato = iTipoContratoRepository.findById(contratoUpdateDTO.getTipoContratoId());
        if(!tipoContrato.isPresent()){
            throw new RegraDeNegocioException("Tipo de contrato não encontrado","ContratoService.create");
        }
        Optional<ClasseContrato> classeContrato = iClasseContratoRepository.findById(contratoUpdateDTO.getClasseContratoId());
        if(!classeContrato.isPresent()){
            throw new RegraDeNegocioException("Classe de contrato não encontrado","ContratoService.create");
        }
        Optional<Administradora> administradora = iAdministradoraRepository.findById(contratoUpdateDTO.getAdministradoraId());
        if(!administradora.isPresent()){
            throw new RegraDeNegocioException("Administradora não encontrada","ContratoService.create");
        }

        Contrato contrato = new Contrato();

        contrato.setId(contratoUpdateDTO.getId());
        contrato.setValor(contratoUpdateDTO.getValor());
        contrato.setNumeroContrato(contratoUpdateDTO.getNumeroContrato());
        contrato.setInicioVigencia(contratoUpdateDTO.getInicioVigencia());
        contrato.setValorDesconto(contratoUpdateDTO.getValorDesconto());
        contrato.setDataAssinaturaContrato(contratoUpdateDTO.getDataAssinaturaContrato());
        contrato.setUsuario(usuario.get());
        contrato.setModalidadePlano(modalidadePlano.get());
        contrato.setTipoContrato(tipoContrato.get());
        contrato.setClasseContrato(classeContrato.get());
        contrato.setAdministradora(administradora.get());

        return iContratoRepository.save(contrato);
    }

    @Override
    public Optional<Contrato> findById(Long contratoId) {
        return iContratoRepository.findById(contratoId);
    }

    @Override
    public List<Contrato> findByUsuarioId(Long usuarioId) {
        return iContratoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Contrato> findByModalidadePlanoId(Long modalidePlanoId) {
        return iContratoRepository.findByModalidadePlanoId(modalidePlanoId);
    }

    @Override
    public List<Contrato> findByTipoContratoId(Long tipoContratoId) {
        return iContratoRepository.findByTipoContratoId(tipoContratoId);
    }

    @Override
    public List<Contrato> findByAdministradoraId(Long administradoraId) {
        return iContratoRepository.findByAdministradoraId(administradoraId);
    }

    @Override
    public void deleteById(Long contratoId) {
        iContratoRepository.deleteById(contratoId);
    }
}
