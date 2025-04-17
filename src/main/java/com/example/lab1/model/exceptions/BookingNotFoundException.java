package com.example.lab1.model.exceptions;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(Long id) {
        super(String.format("Booking with id: %d was not found", id));
    }
}