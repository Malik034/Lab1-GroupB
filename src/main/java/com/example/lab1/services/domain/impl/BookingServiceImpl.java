package com.example.lab1.services.domain.impl;

import com.example.lab1.model.domain.Accommodation;
import com.example.lab1.model.domain.Booking;
import com.example.lab1.model.domain.User;
import com.example.lab1.model.exceptions.AccommodationAlreadyInBookingException;
import com.example.lab1.model.exceptions.AccommodationNotFoundException;
import com.example.lab1.model.exceptions.BookingNotFoundException;
import com.example.lab1.repository.BookingRepository;
import com.example.lab1.services.domain.AccommodationService;
import com.example.lab1.services.domain.BookingService;
import com.example.lab1.services.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    UserService userService;
    AccommodationService accommodationService;

    public BookingServiceImpl(BookingRepository bookingRepository, UserService userService, AccommodationService accommodationService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.accommodationService = accommodationService;
    }

    @Override
    public List<Accommodation> listAllAccommodationsInBooking(Long bookingId) {
        if (bookingRepository.findById(bookingId).isEmpty())
            throw new BookingNotFoundException(bookingId);
        return bookingRepository.findById(bookingId).get().getAccommodations();
    }

    @Override
    public Optional<Booking> getActiveBooking(String username) {
        User user = userService.findByUsername(username);

        return Optional.of(bookingRepository.findByUser(user)
                .orElseGet(() -> bookingRepository.save(new Booking(user))));
    }

    @Override
    public Optional<Booking> addAccommodationToBooking(String username, Long accommodationId) {
        if (getActiveBooking(username).isPresent()) {
            Booking booking = getActiveBooking(username).get();

            Accommodation accommodation = accommodationService.findById(accommodationId)
                    .orElseThrow(() -> new AccommodationNotFoundException(accommodationId));
            if (!booking.getAccommodations().stream().filter(i -> i.getId().equals(accommodationId)).toList().isEmpty())
                throw new AccommodationAlreadyInBookingException(accommodationId, username);
            booking.getAccommodations().add(accommodation);
            return Optional.of(bookingRepository.save(booking));
        }
        return Optional.empty();
    }
}