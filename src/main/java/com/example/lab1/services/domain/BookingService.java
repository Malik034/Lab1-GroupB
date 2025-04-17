package com.example.lab1.services.domain;

import com.example.lab1.model.domain.Accommodation;
import com.example.lab1.model.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Accommodation> listAllAccommodationsInBooking(Long bookingId);

    Optional<Booking> getActiveBooking(String username);

    Optional<Booking> addAccommodationToBooking(String username, Long accommodationId);
}
