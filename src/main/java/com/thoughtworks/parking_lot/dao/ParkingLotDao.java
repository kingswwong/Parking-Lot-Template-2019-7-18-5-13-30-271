package com.thoughtworks.parking_lot.dao;

import com.thoughtworks.parking_lot.base.BaseRepository;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotDao extends BaseRepository<ParkingLot, Long> {
}
