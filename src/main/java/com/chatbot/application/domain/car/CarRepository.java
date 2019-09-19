package com.chatbot.application.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from car c where maker_id = ?1")
    List<Car> findByMakerId(long makerId);
}
