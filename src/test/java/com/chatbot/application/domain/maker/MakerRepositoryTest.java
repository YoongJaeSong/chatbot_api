package com.chatbot.application.domain.maker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MakerRepositoryTest {

    @Autowired
    MakerRepository repository;

    @Test
    public void 메이커_정보_조회() {
        repository.save(Maker.builder()
                .no(26)
                .name("르노삼성")
                .build());

        List<Maker> makers = repository.findAll();

        Maker maker = makers.get(0);
        assertThat(maker.getName(), is("르노삼성"));
    }
}