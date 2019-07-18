package com.thoughtworks.parking_lot.dao;

import com.thoughtworks.parking_lot.base.BaseRepository;
import com.thoughtworks.parking_lot.entity.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends BaseRepository<Car, Long> {
}
