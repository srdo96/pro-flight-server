package com.ars.proflight.controller;

import com.ars.proflight.model.ReservationModel;
import com.ars.proflight.repository.ReservationRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservations")
@Tag(name = "Reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository; // Assuming you have a ReservationRepository

    // Create a new reservation
    @PostMapping("/create")
    public ResponseEntity<ReservationModel> createReservation(@RequestBody ReservationModel reservation) {
        // Perform validation and business logic as needed
        ReservationModel createdReservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    // Retrieve all reservations
    @GetMapping("/list")
    public ResponseEntity<List<ReservationModel>> listReservations() {
        List<ReservationModel> reservations = reservationRepository.findAll();
        return ResponseEntity.ok(reservations);
    }

    // Retrieve a specific reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservationModel> getReservationById(@PathVariable String id) {
        Optional<ReservationModel> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an existing reservation
    @PutMapping("/{id}")
    public ResponseEntity<ReservationModel> updateReservation(@PathVariable String id, @RequestBody ReservationModel updatedReservation) {
        if (reservationRepository.existsById(id)) {
            updatedReservation.setId(id);
            ReservationModel updated = reservationRepository.save(updatedReservation);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Cancel a reservation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable String id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
