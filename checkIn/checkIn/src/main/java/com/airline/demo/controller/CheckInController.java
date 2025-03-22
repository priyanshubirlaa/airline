package com.airline.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.entity.CheckIn;
import com.airline.demo.service.CheckInService;

@RestController
@RequestMapping("/checkin")
@CrossOrigin(origins = "http://localhost:3000")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @PostMapping("/{userId}")
    public ResponseEntity<CheckIn> checkIn(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(checkInService.checkInUser(userId));
    }

}
