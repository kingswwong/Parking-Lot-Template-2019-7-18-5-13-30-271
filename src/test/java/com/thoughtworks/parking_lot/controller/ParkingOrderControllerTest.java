package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingOrderController.class)
public class ParkingOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingOrderService parkingOrderService;


    @Test
    void should_return_success_msg() throws Exception {

        when(parkingOrderService.save(ArgumentMatchers.any())).thenReturn(new ParkingOrder());
        String parking = "{\n" +
                "\t\"parkingLotId\":1,\n" +
                "\t\"car\":{\n" +
                "\t\t\"id\":1\n" +
                "\t}\n" +
                "}";
        ResultActions resultActions = mockMvc.perform(post("/orders/parkCarMsg").contentType(MediaType.APPLICATION_JSON).content(parking));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$", is("成功")));
    }

    @Test
    void should_return_fail_msg() throws Exception{
        when(parkingOrderService.save(ArgumentMatchers.any())).thenReturn(null);
        String parking = "{\n" +
                "\t\"parkingLotId\":1,\n" +
                "\t\"car\":{\n" +
                "\t\t\"id\":1\n" +
                "\t}\n" +
                "}";
        ResultActions resultActions = mockMvc.perform(post("/orders/parkCarMsg").contentType(MediaType.APPLICATION_JSON).content(parking));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$", is("停车场已经满")));
    }

    @Test
    void should_fetch_car_success() throws Exception{
        when(parkingOrderService.update(ArgumentMatchers.any())).thenReturn(new ParkingOrder());
        String fetching = "{\n" +
                "    \"id\": 1,\n" +
                "    \"parkingLotId\": 1,\n" +
                "    \"car\": {\n" +
                "        \"id\": 1,\n" +
                "        \"carNumber\": \"car4\"\n" +
                "    },\n" +
                "    \"startTime\": \"2019-07-18T11:33:19.602+0000\",\n" +
                "    \"endTime\": \"2019-07-18T11:33:34.328+0000\",\n" +
                "    \"flag\": 1\n" +
                "}";
        ResultActions resultActions = mockMvc.perform(delete("/orders/fetchCarMsg").contentType(MediaType.APPLICATION_JSON).content(fetching));
        resultActions.andExpect(status().isOk());
    }

}
