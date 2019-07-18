package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.base.BaseController;
import com.thoughtworks.parking_lot.dao.ParkingLotDao;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
    @RequestMapping(value = "/orders")
public class ParkingOrderController extends BaseController<ParkingOrder, Long> {

    @Autowired
    private ParkingOrderService parkingOrderService;

    public ParkingOrderController(@Autowired ParkingOrderService parkingOrderService) {
        super(parkingOrderService);
    }

    @PostMapping("/parkCarMsg")
    public String parkCar(@RequestBody ParkingOrder parkingOrder){
        ParkingOrder parkingOrder1 = parkingOrderService.save(parkingOrder);
        return parkingOrder1 == null ? "停车场已经满" : "成功";
    }

    @DeleteMapping("/fetchCarMsg")
    public ParkingOrder fetchCar(@RequestBody ParkingOrder parkingOrder){
        ParkingOrder oldParkingOrder = parkingOrderService.findById(parkingOrder.getParkingLotId());
        oldParkingOrder.setEndTime(new Date());
        oldParkingOrder.setFlag(0);
        return parkingOrderService.update(oldParkingOrder);
    }
}
