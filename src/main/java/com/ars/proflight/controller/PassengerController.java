package com.ars.proflight.controller;

import com.ars.proflight.model.PassengerModel;
import com.ars.proflight.repository.PassengerRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/passenger")
@Tag(name = "Passenger")
public class PassengerController {

    @Autowired
    PassengerRepository repo;

    @GetMapping("/getAllPassengers")

    public List<PassengerModel> getAllPassengers() {
        return repo.findAll();
    }

    @PostMapping("addPassenger")

    public PassengerModel addPassenger(@RequestBody PassengerModel passenger) {
        return repo.save(passenger);
    }

    @PutMapping("/updatePassenger/{id}")
    public ResponseEntity<PassengerModel> updatePassenger(
            @PathVariable String id,
            @RequestBody PassengerModel updatedPassenger) {
        Optional<PassengerModel> existingPassenger = repo.findById(id);

        if (existingPassenger.isPresent()) {
            updatedPassenger.setId(id); // Set the ID of the updated passenger
            PassengerModel savedPassenger = repo.save(updatedPassenger);
            return ResponseEntity.ok(savedPassenger);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/updatePassenger/{id}")
    public ResponseEntity<PassengerModel> patchPassenger(
            @PathVariable String id,
            @RequestBody Map<String, Object> updatedFields) {

        Optional<PassengerModel> optionalPassenger = repo.findById(id);

        if (optionalPassenger.isPresent()) {
            PassengerModel passenger = optionalPassenger.get();

            // Update specific fields based on the updatedFields map
            if (updatedFields.containsKey("firstName")) {
                passenger.setFirstName((String) updatedFields.get("firstName"));
            }
            if (updatedFields.containsKey("lastName")) {
                passenger.setLastName((String) updatedFields.get("lastName"));
            }
            if (updatedFields.containsKey("address")) {
                passenger.setAddress((String) updatedFields.get("address"));
            }
            if (updatedFields.containsKey("passportCode")) {
                passenger.setPassportCode((String) updatedFields.get("passportCode"));
            }

            // Save the updated passenger
            PassengerModel updatedPassenger = repo.save(passenger);
            return ResponseEntity.ok(updatedPassenger);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/removePassenger/{id}")
    public ResponseEntity<Void> removePassenger(@PathVariable String id) {
        Optional<PassengerModel> existingPassenger = repo.findById(id);

        if (existingPassenger.isPresent()) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
