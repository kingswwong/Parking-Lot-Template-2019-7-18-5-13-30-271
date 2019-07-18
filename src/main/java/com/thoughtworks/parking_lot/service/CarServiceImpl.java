package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.base.BaseServiceImpl;
import com.thoughtworks.parking_lot.dao.CarDao;
import com.thoughtworks.parking_lot.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BaseServiceImpl<Car, Long> implements CarService {


    @Autowired
    CarDao orderDao;

    public CarServiceImpl(@Autowired CarDao carDao) {
        super(carDao);
    }

}
