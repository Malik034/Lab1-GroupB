package com.example.lab1.dto;

import com.example.lab1.model.domain.Booking;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

public record DisplayBookingDto(Long id, LocalDateTime createdAt, DisplayUserDto user, List<DisplayAccommodationDto> accommodation) {

    public static DisplayBookingDto from(Booking booking) {
        return new DisplayBookingDto(
                booking.getId(),
                booking.getCreatedAt(),
                DisplayUserDto.from(booking.getUser()),
                DisplayAccommodationDto.from(booking.getAccommodations()));
    }
}