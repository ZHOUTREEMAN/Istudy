package com.xmu.istudy.service;

import com.xmu.istudy.entity.Room;
import com.xmu.istudy.entity.Seat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

@FeignClient("istudy-room")
@Service
public interface RoomFeign {

    @GetMapping("roomService/room/{roomId}")
    Room getRoomById(@PathVariable Long roomId);

    @GetMapping("roomService/room/{seatId}")
    Seat selectOne(@PathVariable Serializable seatId);
}
