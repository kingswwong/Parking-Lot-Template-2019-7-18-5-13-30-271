package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.base.BaseService;
import com.thoughtworks.parking_lot.entity.ParkingLot;

public interface ParkingLotService extends BaseService<ParkingLot, Long> {

    void update(Long id, ParkingLot parkingLot);
}
