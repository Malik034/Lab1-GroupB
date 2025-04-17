package com.example.lab1.repository;

import com.example.lab1.model.domain.Booking;
import com.example.lab1.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByUser(User user);
}
