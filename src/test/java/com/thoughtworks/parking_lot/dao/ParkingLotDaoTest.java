package com.thoughtworks.parking_lot.dao;


import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ParkingLotDaoTest {

    @Autowired
    private ParkingLotDao parkingLotDao;

    @Test
    void should_add_a_parkinglot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(Long.parseLong("1"));
        parkingLot.setCapacity(20);
        parkingLot.setLocation("location");
        parkingLot.setName("lot1");

        parkingLotDao.saveAndFlush(parkingLot);
        ParkingLot parkingLot1 = parkingLotDao.findById(parkingLot.getId()).get();

        assertEquals(parkingLot1.getName(),"lot1");
    }

    @Test
    void should_find_a_parkinglot_by_id() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(Long.parseLong("1"));
        parkingLot.setCapacity(20);
        parkingLot.setLocation("location");
        parkingLot.setName("lot1");

        parkingLotDao.saveAndFlush(parkingLot);

        assertEquals(parkingLotDao.findById(parkingLot.getId()).get().getName(),"lot1");
    }

    @Test
    void should_update_paringlot_size() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(Long.parseLong("1"));
        parkingLot.setCapacity(20);
        parkingLot.setLocation("location");
        parkingLot.setName("lot1");

        parkingLotDao.saveAndFlush(parkingLot);
        parkingLot.setCapacity(30);
        parkingLotDao.save(parkingLot);
        assertEquals(parkingLotDao.findById(parkingLot.getId()).get().getCapacity(),30);
    }

    @Test
    void should_delete_parkinglot_by_id(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(Long.parseLong("1"));
        parkingLot.setCapacity(20);
        parkingLot.setLocation("location");
        parkingLot.setName("lot1");

        parkingLotDao.saveAndFlush(parkingLot);
        parkingLotDao.delete(parkingLot);
        List<ParkingLot> parkingLots = parkingLotDao.findAll();
        assertEquals(parkingLots.size(),0);
    }
}
