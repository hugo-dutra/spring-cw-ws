package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.classecontrato.ClasseContratoCreateDTO;
import com.corretoraweb.ws.dtos.classecontrato.ClasseContratoUpdateDTO;
import com.corretoraweb.ws.entities.ClasseContrato;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.entities.TipoContrato;
import com.corretoraweb.ws.exceptions.RegraDeNegocioException;
import com.corretoraweb.ws.interfaces.IClasseContratoService;
import com.corretoraweb.ws.repositories.IClasseContratoRepository;
import com.corretoraweb.ws.repositories.ICorretoraRepository;
import com.corretoraweb.ws.repositories.ITipoContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClasseContratoService implements IClasseContratoService {
    private final IClasseContratoRepository iClasseContratoRepository;
    private final ICorretoraRepository iCorretoraRepository;
    private  final ITipoContratoRepository iTipoContratoRepository;

    @Override
    public ClasseContrato create(ClasseContratoCreateDTO classeContratoCreateDTO) {
        Optional<Corretora> corretora = iCorretoraRepository.findById(classeContratoCreateDTO.getCorretoraId());
        if(!corretora.isPresent()){
           throw new RegraDeNegocioException("Corretora não encontrada","ClasseContratoService.create");
        }
        Optional<TipoContrato> tipoContrato = iTipoContratoRepository.findById(classeContratoCreateDTO.getTipoContratoId());
        if(!tipoContrato.isPresent()){
            throw new RegraDeNegocioException("Tipo de contrato não encontrado","ClasseContratoService.create");
        }
        ClasseContrato classeContrato = new ClasseContrato();
        classeContrato.setTipoContrato(tipoContrato.get());
        classeContrato.setCorretora(corretora.get());
        classeContrato.setNome(classeContratoCreateDTO.getNome());
        return iClasseContratoRepository.save(classeContrato);
    }

    @Override
    public ClasseContrato update(ClasseContratoUpdateDTO classeContratoUpdateDTO) {
        Optional<ClasseContrato> classeContrato = iClasseContratoRepository.findById(classeContratoUpdateDTO.getId());
        if(!classeContrato.isPresent()){
            throw new RegraDeNegocioException("Classe do contrato não encontrada","ClasseContratoService.update");
        }
        Optional<Corretora> corretora = iCorretoraRepository.findById(classeContratoUpdateDTO.getCorretoraId());
        if(!corretora.isPresent()){
            throw new RegraDeNegocioException("Corretora não encontrada","ClasseContratoService.update");
        }
        Optional<TipoContrato> tipoContrato = iTipoContratoRepository.findById(classeContratoUpdateDTO.getTipoContratoId());
        if(!tipoContrato.isPresent()){
            throw new RegraDeNegocioException("Tipo de contrato não encontrado","ClasseContratoService.update");
        }
        ClasseContrato classeContratoAlterada = new ClasseContrato();
        classeContratoAlterada.setCorretora(corretora.get());
        classeContratoAlterada.setTipoContrato(tipoContrato.get());
        classeContratoAlterada.setNome(classeContratoUpdateDTO.getNome());

        return iClasseContratoRepository.save(classeContratoAlterada);
    }

    @Override
    public void delete(Long classeContratoId) {
        iClasseContratoRepository.deleteById(classeContratoId);
    }

    @Override
    public Optional<ClasseContrato> findById(Long classeContratoId) {
        return iClasseContratoRepository.findById(classeContratoId);
    }

    @Override
    public List<ClasseContrato> findByCorretoraId(Long corretoraId) {
        return iClasseContratoRepository.findByCorretoraId(corretoraId);
    }
}
