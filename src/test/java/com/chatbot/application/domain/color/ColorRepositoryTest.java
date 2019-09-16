package com.chatbot.application.domain.color;

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
public class ColorRepositoryTest {

    @Autowired
    ColorRepository repository;

    @Test
    public void 모든_색상_조회() {
        //given
        repository.save(Color.builder()
                .color("흰색")
                .rgb("#ffffff")
                .build());

        //when
        List<Color> colors = repository.findAll();

        //then
        Color color = colors.get(0);
        assertThat(color.getColor(), is("흰색"));
        assertThat(color.getRgb(), is("#ffffff"));
    }
}