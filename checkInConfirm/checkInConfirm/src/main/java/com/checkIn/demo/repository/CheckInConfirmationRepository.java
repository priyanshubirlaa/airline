package com.checkIn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkIn.demo.entity.CheckInConfirmation;

@Repository
public interface CheckInConfirmationRepository extends JpaRepository<CheckInConfirmation, Long> {
}
