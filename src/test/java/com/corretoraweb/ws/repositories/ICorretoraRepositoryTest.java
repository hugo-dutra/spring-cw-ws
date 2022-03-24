package com.corretoraweb.ws.repositories;

import com.corretoraweb.ws.entities.Corretora;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ICorretoraRepositoryTest {

    @Autowired
    private ICorretoraRepository underTest;

    @Test
    void itShouldCheckIfCorretoraExistsByEmail() {
        //given
        Corretora corretora = new Corretora("Corretora Hugo", "hugo.dutra@yahoo.com.br", "61982086449");
        underTest.save(corretora);
        //when
        Boolean exists = underTest.existsByEmail("hugo.dutra@yahoo.com.br").get();
        //then
        assertThat(exists).isTrue();
    }
}