package com.ars.proflight.controller;

import com.ars.proflight.model.FlightModel;
import com.ars.proflight.repository.FlightRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/flights")
@Tag(name = "Flight")

public class FlightController {
    @Autowired
    FlightRepository flightRepo;

    // Create a new flight
    @PostMapping
    public ResponseEntity<FlightModel> createFlight(@RequestBody FlightModel flight) {
        FlightModel createdFlight = flightRepo.save(flight);
        return ResponseEntity.ok(createdFlight);
    }

    // Retrieve all flights
    @GetMapping
    public List<FlightModel> getAllFlights() {
        return flightRepo.findAll();
    }

    // Retrieve a specific flight by ID
    @GetMapping("/{id}")
    public ResponseEntity<FlightModel> getFlightById(@PathVariable String id) {
        Optional<FlightModel> flight = flightRepo.findById(id);
        if (flight.isPresent()) {
            return ResponseEntity.ok(flight.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an existing flight
//    @PutMapping("/updateFlight/{id}")
//    public ResponseEntity<FlightModel> updateFlight(@PathVariable String id, @RequestBody FlightModel updatedFlight) {
//        Optional<FlightModel> existingFlight = flightRepo.findById(id);
//        FlightModel updated = flightRepo.updateFlight(id, updatedFlight);
////        Optional<FlightModel> existingFlight = flightRepo.findById(id);
////        if (existingFlight.isPresent()) {
////            existingFlight.setId(id); // Set the ID of the updated passenger
////            FlightModel savedPassenger = flightRepo.save(updatedFlight);
////            return ResponseEntity.ok(savedPassenger);
////        } else {
////            return ResponseEntity.notFound().build();
//////        }
//        if (updated != null) {
//            return ResponseEntity.ok(updated);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//        }


    // Update an existing flight
    @PutMapping("update-flight/{id}")
    public ResponseEntity<FlightModel> updateFlight(@PathVariable String id, @RequestBody FlightModel updatedFlight) {
        if (flightRepo.existsById(id)) {
            updatedFlight.setFlightNumber(id); // Ensure the ID is set correctly
            FlightModel updated = flightRepo.save(updatedFlight);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a flight by ID
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeFlight(@PathVariable String id) {
        Optional<FlightModel> existingFlight = flightRepo.findById(id);

        if (existingFlight.isPresent()) {
            flightRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

//        flightRepo.deleteFlight(id);
//        return ResponseEntity.noContent().build();
    }
}
