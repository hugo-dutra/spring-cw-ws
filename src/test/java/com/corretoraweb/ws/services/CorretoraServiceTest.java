package com.corretoraweb.ws.services;

import com.corretoraweb.ws.dtos.corretora.CorretoraCreateDTO;
import com.corretoraweb.ws.dtos.corretora.CorretoraUpdateDTO;
import com.corretoraweb.ws.entities.Corretora;
import com.corretoraweb.ws.interfaces.ICorretoraService;
import com.corretoraweb.ws.repositories.ICorretoraRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CorretoraServiceTest {

    @Autowired
    private ICorretoraService iCorretoraService;


    @AfterEach
    void tearDown() {
        iCorretoraService.deleteAll();;
    }

    @Test
    void create() {
        //give
        CorretoraCreateDTO corretoraCreateDTO = new CorretoraCreateDTO();
        corretoraCreateDTO.setNome("Corretora Hugo 2");
        corretoraCreateDTO.setEmail("hugo.dutra@yahoo.com.br");
        corretoraCreateDTO.setTelefone("555-5555");
        //when
        Corretora corretora = iCorretoraService.create(corretoraCreateDTO);
        //then
        Corretora newCorretora = iCorretoraService.findById(corretora.getId()).get();
        assertThat(corretora).isEqualTo(newCorretora);
    }

    @Test
    void findAll() {
        //Give
        CorretoraCreateDTO corretoraCreateDTO = new CorretoraCreateDTO();
        corretoraCreateDTO.setNome("Corretora Hugo 2");
        corretoraCreateDTO.setEmail("hugo.dutra@yahoo.com.br");
        corretoraCreateDTO.setTelefone("555-5555");
        Corretora corretora = iCorretoraService.create(corretoraCreateDTO);
        //when
        List<Corretora> corretoras = iCorretoraService.findAll();
        //When
        assertThat(corretoras.size()).isGreaterThan(0);
    }

    @Test
    void update() {

    }

    @Test
    void delete() {

    }

    @Test
    void existsByEmail() {
        //Give
        CorretoraCreateDTO corretoraCreateDTO = new CorretoraCreateDTO();
        corretoraCreateDTO.setNome("Corretora Hugo 2");
        corretoraCreateDTO.setEmail("hugo.dutra@yahoo.com.br");
        corretoraCreateDTO.setTelefone("555-5555");
        Corretora corretora = iCorretoraService.create(corretoraCreateDTO);
        //When
        Boolean exists = iCorretoraService.existsByEmail(corretoraCreateDTO.getEmail()).get();
        //Then
        assertThat(exists).isTrue();
    }

    @Test
    void findById() {
    }
}