package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.base.BaseController;
import com.thoughtworks.parking_lot.entity.Car;
import com.thoughtworks.parking_lot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars")
public class CarController extends BaseController<Car, Long> {

    @Autowired
    CarService carService;

    public CarController(@Autowired CarService carService) {
        super(carService);
    }


}
