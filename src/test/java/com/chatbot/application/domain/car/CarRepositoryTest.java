package com.chatbot.application.domain.car;

import com.chatbot.application.domain.maker.Maker;
import com.chatbot.application.domain.maker.MakerRepository;
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
public class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;

    @Test
    public void 메이커_아이디로_차량_조회() {
        //given
        carRepository.save(Car.builder()
                .modelNo(1)
                .model("test model")
                .levelNo(1)
                .level("test level")
                .classNo(1)
                .className("test class")
                .year(2019)
                .maker(Maker.builder()
                        .no(1)
                        .name("테스트")
                        .build())
                .build());

        //when
        List<Car> cars = carRepository.findByMakerId(1);
        Car car = cars.get(0);

        //then
        assertThat(car.getModel(), is("test model"));
        assertThat(car.getMaker().getName(), is("테스트"));
        assertThat(car.getLevelNo(), is(1));
        assertThat(car.getLevel(), is("test level"));
    }
}