package com.chatbot.application.service;

import com.chatbot.application.domain.maker.Maker;
import com.chatbot.application.domain.maker.MakerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MakerServiceTest {

    @Autowired
    private MakerRepository repository;

    @Autowired
    private MakerService makerService;

    @Test
    public void 특정_메이커_조회() {
        //given
        repository.save(Maker.builder()
                .no(22)
                .name("르노삼성")
                .build());

        Maker maker = makerService.getMaker(22);

        assertThat(maker.getNo(), is(22));
        assertThat(maker.getNo(), is("르노삼성"));
    }
}