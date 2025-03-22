package com.checkIn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkIn.demo.entity.CheckInConfirmation;
import com.checkIn.demo.service.CheckInConfirmationService;

@RestController
@RequestMapping("/confirmation")
@CrossOrigin(origins = "http://localhost:3000")
public class CheckInConfirmationController {
    @Autowired
    private CheckInConfirmationService checkInConfirmationService;

    @PostMapping("/{userId}")
    public ResponseEntity<CheckInConfirmation> confirmCheckIn(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(checkInConfirmationService.confirmCheckIn(userId));
    }

}
