package com.seat.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seat.demo.entity.Seat;
import com.seat.demo.repository.SeatRepository;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeatMap() {
        return seatRepository.findAll();
    }
    

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat selectSeat(String seatNumber) {
        Seat seat = seatRepository.findBySeatNumber(seatNumber)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        if (seat.isBooked()) {
            throw new RuntimeException("Seat already booked");
        }
        seat.setBooked(true);
        return seatRepository.save(seat);
    }
}
