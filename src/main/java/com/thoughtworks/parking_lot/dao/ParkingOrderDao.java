package com.thoughtworks.parking_lot.dao;

import com.thoughtworks.parking_lot.base.BaseRepository;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingOrderDao extends BaseRepository<ParkingOrder, Long> {
}
