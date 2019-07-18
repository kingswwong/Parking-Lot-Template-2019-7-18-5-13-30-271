package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.controller.ParkingLotController;
import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingLotController.class)
public class ParkingLotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingLotService parkingLotService;

    @Test
    void should_find_parkinglot_by_id() throws Exception{
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(Long.parseLong("1"));
        parkingLot.setCapacity(20);
        parkingLot.setLocation("location");
        parkingLot.setName("lot1");

        when(parkingLotService.findById(anyLong())).thenReturn(parkingLot);
        ResultActions resultActions = mockMvc.perform(get("/lots/{id}",1));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.capacity",is(20)))
                .andExpect(jsonPath("$.name",is("lot1")));
    }

    @Test
    void should_find_all_parkinglots() throws Exception{
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(Long.parseLong("1"));
        parkingLot.setCapacity(20);
        parkingLot.setLocation("location");
        parkingLot.setName("lot1");
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLot2.setId(Long.parseLong("2"));
        parkingLot2.setCapacity(10);
        parkingLot2.setLocation("location2");
        parkingLot2.setName("lot2");
        when(parkingLotService.findAll()).thenReturn(Arrays.asList(parkingLot,parkingLot2));
        ResultActions resultActions = mockMvc.perform(get("/lots"));
        resultActions.andExpect(status().isOk());
    }

    @Test
    void should_add_a_parkinglot() throws Exception{
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(Long.parseLong("1"));
        parkingLot.setCapacity(20);
        parkingLot.setLocation("location");
        parkingLot.setName("lot1");
        when(parkingLotService.save(ArgumentMatchers.any())).thenReturn(parkingLot);
        ResultActions resultActions = mockMvc.perform(get("/lots"));
        resultActions.andExpect(status().isOk());
    }


}
