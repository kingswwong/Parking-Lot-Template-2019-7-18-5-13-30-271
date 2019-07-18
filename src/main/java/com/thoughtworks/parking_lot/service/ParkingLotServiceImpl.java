package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.base.BaseRepository;
import com.thoughtworks.parking_lot.base.BaseService;
import com.thoughtworks.parking_lot.base.BaseServiceImpl;
import com.thoughtworks.parking_lot.dao.ParkingLotDao;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotServiceImpl extends BaseServiceImpl<ParkingLot, Long> implements ParkingLotService {


    @Autowired
    ParkingLotDao parkingLotDao;

    public ParkingLotServiceImpl(@Autowired ParkingLotDao parkingLotDao) {
        super(parkingLotDao);
    }

    @Override
    public void update(Long id, ParkingLot parkingLot) {
        ParkingLot oldParkingLot = parkingLotDao.findById(id).orElse(null);
        oldParkingLot.setCapacity(parkingLot.getCapacity());
        parkingLotDao.saveAndFlush(oldParkingLot);
    }
}
