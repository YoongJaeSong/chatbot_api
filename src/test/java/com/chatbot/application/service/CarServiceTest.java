package com.chatbot.application.service;

import com.chatbot.application.domain.car.Car;
import com.chatbot.application.domain.car.CarRepository;
import com.chatbot.application.domain.maker.Maker;
import com.chatbot.application.domain.maker.MakerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarServiceTest {

    @Autowired
    MakerRepository makerRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Test
    public void 차량조회() {
        Maker maker = Maker.builder().no(26)
                .name("test")
                .build();

        carRepository.save(Car.builder()
                .modelNo(1)
                .model("test model")
                .levelNo(1)
                .level("test level")
                .classNo(1)
                .className("test class")
                .year(2019)
                .maker(maker)
                .build());

        Car car = carRepository.findAll().get(0);

        assertThat(car.getModelNo(), is(1));
        assertThat(car.getModel(), is("test model"));
        assertThat(car.getLevelNo(), is(1));
        assertThat(car.getLevel(), is("test level"));
        assertThat(car.getClassNo(), is(1));
        assertThat(car.getClassName(), is("test class"));
        assertThat(car.getYear(), is(2019));
        assertThat(car.getMaker().getName(), is("test"));
    }
}