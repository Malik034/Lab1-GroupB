package com.example.lab1.services.application.impl;

import com.example.lab1.dto.DisplayAccommodationDto;
import com.example.lab1.dto.DisplayBookingDto;
import com.example.lab1.services.application.BookingApplicationService;
import com.example.lab1.services.domain.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingApplicationServiceImpl implements BookingApplicationService {

    BookingService bookingService;

    public BookingApplicationServiceImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public List<DisplayAccommodationDto> listAllAccommodationsInBooking(Long bookingId) {
        return DisplayAccommodationDto.from(bookingService.listAllAccommodationsInBooking(bookingId));
    }

    @Override
    public Optional<DisplayBookingDto> getActiveBooking(String username) {
        return bookingService.getActiveBooking(username).map(DisplayBookingDto::from);
    }

    @Override
    public Optional<DisplayBookingDto> addAccommodationToBooking(String username, Long accommodationId) {
        return bookingService.addAccommodationToBooking(username, accommodationId).map(DisplayBookingDto::from);
    }
}