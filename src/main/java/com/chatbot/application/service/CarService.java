package com.chatbot.application.service;

import com.chatbot.application.domain.car.Car;
import com.chatbot.application.domain.car.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository repository;

    public List<Car> getCarsByMakerId(long makerId){
        return repository.findByMakerId(makerId);
    }

}
