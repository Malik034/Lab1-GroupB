package com.example.lab1.services.application;

import com.example.lab1.dto.display.DisplayAccommodationDto;
import com.example.lab1.dto.display.DisplayBookingDto;

import java.util.List;
import java.util.Optional;

public interface BookingApplicationService {
    List<DisplayAccommodationDto> listAllAccommodationsInBooking(Long bookingId);

    Optional<DisplayBookingDto> getActiveBooking(String username);

    Optional<DisplayBookingDto> addAccommodationToBooking(String username, Long accommodationId);
}
