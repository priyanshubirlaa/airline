package com.airline.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.demo.entity.CheckIn;
import com.airline.demo.repository.CheckInRepository;

@Service
public class CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    public CheckIn checkInUser(Long userId) {
    	 if (checkInRepository.findByUserId(userId).isPresent()) {
             throw new RuntimeException("User is already checked in!");
         }
        CheckIn checkIn = new CheckIn();
        checkIn.setUserId(userId);
        checkIn.setCheckedIn(true);
        return checkInRepository.save(checkIn);
    }
}
