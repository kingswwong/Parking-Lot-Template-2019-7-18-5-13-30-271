package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.base.BaseServiceImpl;
import com.thoughtworks.parking_lot.dao.ParkingLotDao;
import com.thoughtworks.parking_lot.dao.ParkingOrderDao;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingOrderServiceImpl extends BaseServiceImpl<ParkingOrder, Long> implements ParkingOrderService {

    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired ParkingOrderDao parkingOrderDao;


    public ParkingOrderServiceImpl(@Autowired ParkingOrderDao parkingOrderDao) {
        super(parkingOrderDao);
    }



    @Override
    public ParkingOrder save(ParkingOrder parkingOrder) {
        ParkingLot parkingLot = parkingLotService.findById(parkingOrder.getParkingLotId());
        if( parkingLot.getCapacity() > parkingLot.getParkingOrders().size()){
            ParkingOrder returnOrder = parkingOrderDao.saveAndFlush(parkingOrder);
            parkingLot.getParkingOrders().add(returnOrder);
            parkingLotService.save(parkingLot);
            return returnOrder;
        }
        return null;
    }
}
