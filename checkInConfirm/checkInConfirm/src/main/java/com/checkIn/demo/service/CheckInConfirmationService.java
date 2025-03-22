package com.checkIn.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkIn.demo.entity.CheckInConfirmation;
import com.checkIn.demo.repository.CheckInConfirmationRepository;

@Service
public class CheckInConfirmationService {
    @Autowired
    private CheckInConfirmationRepository checkInConfirmationRepository;

    public CheckInConfirmation confirmCheckIn(Long userId) {
    	  if (checkInConfirmationRepository.findById(userId).isPresent()) {
              throw new RuntimeException("Check-in confirmation already sent!");
          }

        CheckInConfirmation confirmation = new CheckInConfirmation();
        confirmation.setUserId(userId);
        confirmation.setMessage("Check-in confirmed for User ID: " + userId);
        return checkInConfirmationRepository.save(confirmation);
    }
}
