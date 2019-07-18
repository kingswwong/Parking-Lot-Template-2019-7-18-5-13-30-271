package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.base.BaseController;
import com.thoughtworks.parking_lot.base.BaseService;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/lots")
public class ParkingLotController extends BaseController<ParkingLot, Long> {

    @Autowired ParkingLotService parkingLotService;

    public ParkingLotController(@Autowired ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @PostMapping
    public ParkingLot save(@RequestBody@Validated ParkingLot parkingLot){
        parkingLotService.save(parkingLot);
        return parkingLot;
    }


    @PatchMapping(value = "/{id}")
    public ParkingLot update(@PathVariable Long id,@RequestBody @Valid ParkingLot parkingLot){
        parkingLotService.update(id, parkingLot);
        ParkingLot newParkingLot = parkingLotService.findById(id);
        return newParkingLot;
    }
}
