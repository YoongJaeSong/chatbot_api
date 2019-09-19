package com.chatbot.application.domain.car;

import com.chatbot.application.domain.car_color.CarColor;
import com.chatbot.application.domain.maker.Maker;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "car")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_no")
    private int modelNo;

    @Column(length = 40)
    private String model;

    @Column(name = "level_no")
    private int levelNo;

    @Column(length = 40)
    private String level;

    @Column(name = "class_no")
    private int classNo;

    @Column(length = 40, name = "class")
    private String className;

    @Column
    private int year;

    @Column
    private int price;

    @Column(length = 30, name = "fuel_type")
    private String fuelType;

    @Column(name = "grand_clearance")
    private int grandClearance;

    @Column(name = "driving_system", columnDefinition = "char(3)")
    private String drivingSystem;

    @Column(length = 50, name = "break_front")
    private String breakFront;

    @Column(length = 50, name = "break_rear")
    private String breakRear;

    @Column
    private int weight;

    @Column(name = "max_speed")
    private int maxSpeed;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "fuel_efficiency_highway")
    private float fuelEfficiencyHighway;

    @Column(name = "fuel_efficiency_combined")
    private float fuelEfficiencyCombined;

    @Column(name = "fuel_efficiency_city")
    private float fuelEfficiencyCity;

    @Column(length = 5, name = "max_torque")
    private String maxTorque;

    @Column(length = 30, name = "guarantee_basic")
    private String guaranteeBasic;

    @Column(length = 30, name = "guarantee_power")
    private String guaranteePower;

    @Column(length = 30)
    private String transmission;

    @Column(name = "wheel_front", columnDefinition = "char(5)")
    private String wheelFront;

    @Column(name = "wheel_rear", columnDefinition = "char(5)")
    private String wheelReal;

    @Column(length = 100, name = "engine_type")
    private String engineType;

    @Column(name = "tire_front")
    private int tireFront;

    @Column(name = "tire_rear")
    private int tireRear;

    @Column
    private int length;

    @Column
    private int width;

    @Column
    private int height;

    @Column
    private int displacement;

    @Column(length = 30, name = "suspension_front")
    private String suspensionFront;

    @Column(length = 30, name = "suspension_rear")
    private String suspensionRear;

    @Column(name = "seating_capacity")
    private int seatingCapacity;

    @Column(length = 40)
    private String steering;

    @Column(name = "cylinder_number")
    private int cylinderNumber;

    @Column(length = 12, name = "max_output")
    private String maxOutput;

    @Column(name = "load_capacity")
    private int loadCapacity;

    @ManyToOne(targetEntity = Maker.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "maker_id")
    private Maker maker;

    @OneToMany
    @JoinColumn(name = "car_id")
    private List<CarColor> carColors = new ArrayList<>();

    @Builder
    public Car(int modelNo, String model, int levelNo, String level, int classNo, String className, int year,
               int price, String fuelType, int grandClearance, String drivingSystem, String breakFront, String breakRear,
               int weight, int maxSpeed, int fuelCapacity, float fuelEfficiencyHighway, float fuelEfficiencyCombined,
               float fuelEfficiencyCity, String maxTorque, String guaranteeBasic, String guaranteePower,
               String transmission, String wheelFront, String wheelReal, String engineType, int tireFront,
               int tireRear, int length, int width, int height, int displacement, String suspensionFront,
               String suspensionRear, int seatingCapacity, String steering, int cylinderNumber, String maxOutput,
               int loadCapacity, Maker maker, List<CarColor> carColors) {
        this.modelNo = modelNo;
        this.model = model;
        this.levelNo = levelNo;
        this.level = level;
        this.classNo = classNo;
        this.className = className;
        this.year = year;
        this.price = price;
        this.fuelType = fuelType;
        this.grandClearance = grandClearance;
        this.drivingSystem = drivingSystem;
        this.breakFront = breakFront;
        this.breakRear = breakRear;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiencyHighway = fuelEfficiencyHighway;
        this.fuelEfficiencyCombined = fuelEfficiencyCombined;
        this.fuelEfficiencyCity = fuelEfficiencyCity;
        this.maxTorque = maxTorque;
        this.guaranteeBasic = guaranteeBasic;
        this.guaranteePower = guaranteePower;
        this.transmission = transmission;
        this.wheelFront = wheelFront;
        this.wheelReal = wheelReal;
        this.engineType = engineType;
        this.tireFront = tireFront;
        this.tireRear = tireRear;
        this.length = length;
        this.width = width;
        this.height = height;
        this.displacement = displacement;
        this.suspensionFront = suspensionFront;
        this.suspensionRear = suspensionRear;
        this.seatingCapacity = seatingCapacity;
        this.steering = steering;
        this.cylinderNumber = cylinderNumber;
        this.maxOutput = maxOutput;
        this.loadCapacity = loadCapacity;
        this.maker = maker;
        this.carColors = carColors;
    }
}
