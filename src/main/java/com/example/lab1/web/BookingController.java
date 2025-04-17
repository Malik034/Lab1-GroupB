package com.example.lab1.web;

import com.example.lab1.dto.DisplayBookingDto;
import com.example.lab1.model.domain.User;
import com.example.lab1.services.application.BookingApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@Tag(name = "Booking API", description = "Endpoints for managing accommodation bookings")
public class BookingController {

    private final BookingApplicationService bookingService;

    public BookingController(BookingApplicationService bookingService) {
        this.bookingService = bookingService;
    }

    @Operation(
            summary = "Get current booking",
            description = "Retrieves the current active booking of the logged-in user"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    @GetMapping
    public ResponseEntity<DisplayBookingDto> getActiveBooking(HttpServletRequest req) {
        String username = req.getRemoteUser();

        return bookingService.getActiveBooking(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Add accommodation to booking",
            description = "Adds an accommodation to the user's active booking if available"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accommodation added to booking"),
            @ApiResponse(responseCode = "400", description = "Accommodation is not available"),
            @ApiResponse(responseCode = "404", description = "Accommodation or booking not found")
    })

    @PostMapping("/add/{accommodationId}")
    public ResponseEntity<DisplayBookingDto> addAccommodationToBooking(
            @PathVariable Long accommodationId,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();

        return bookingService.addAccommodationToBooking(user.getUsername(), accommodationId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}