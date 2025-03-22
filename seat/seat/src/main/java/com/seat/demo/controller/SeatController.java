package com.seat.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seat.demo.entity.Seat;
import com.seat.demo.service.SeatService;

@RestController
@RequestMapping("/seat")
@CrossOrigin(origins = "http://localhost:3000")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("/map")
    public ResponseEntity<List<Seat>> getSeatMap() {
        return ResponseEntity.ok(seatService.getSeatMap());
    }

    @PostMapping("/select/{seatNumber}")
    public ResponseEntity<Seat> selectSeat(@PathVariable("seatNumber") String seatNumber) {
        return ResponseEntity.ok(seatService.selectSeat(seatNumber));
    }
    
    @PostMapping("/add")
    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
        Seat savedSeat = seatService.saveSeat(seat);
        return ResponseEntity.ok(savedSeat);
    }

}
