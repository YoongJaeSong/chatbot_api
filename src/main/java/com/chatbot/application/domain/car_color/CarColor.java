package com.chatbot.application.domain.car_color;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "car_color")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "car_id")
    private long carId;

    @Column(name = "color_id")
    private long colorId;

    @Builder
    public CarColor(long carId, long colorId) {
        this.carId = carId;
        this.colorId = colorId;
    }
}
