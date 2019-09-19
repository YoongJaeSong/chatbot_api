package com.chatbot.application.controller;

import com.chatbot.application.domain.car.Car;
import com.chatbot.application.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {

    private CarService service;

    @GetMapping("/api/cars/{makerId}")
    public List<Car> findCarsByMakerId(@PathVariable long makerId){
        return service.getCarsByMakerId(makerId);
    }

}
