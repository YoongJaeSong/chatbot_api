package com.chatbot.application.domain.car;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarRepositoryTest {

    @Autowired
    CarRepository repository;

    @Test
    public void 차량조회(){
        //given
    }
}