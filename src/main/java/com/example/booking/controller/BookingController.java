package com.example.booking.controller;

import com.example.booking.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final Map<String, Booking> bookings = new HashMap<>();

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        bookings.put(booking.getId(), booking);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable String id) {
        Booking booking = bookings.get(id);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
        bookings.put(booking.getId(), booking);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        bookings.remove(id);
        return ResponseEntity.noContent().build();
    }
}
