package com.ars.proflight.controller;

import com.ars.proflight.model.TicketModel;
import com.ars.proflight.repository.TicketRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tickets")
@Tag(name = "Ticket")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository; // Assuming you have a TicketRepository

    // Create a new ticket
    @PostMapping("/create")
    public ResponseEntity<TicketModel> createTicket(@RequestBody TicketModel ticket) {
        // Perform validation and business logic as needed
        TicketModel createdTicket = ticketRepository.save(ticket); // Save the ticket to the database
        return ResponseEntity.ok(createdTicket);
    }

    // Retrieve all tickets
    @GetMapping("/list")
    public ResponseEntity<List<TicketModel>> listTickets() {
        List<TicketModel> tickets = ticketRepository.findAll();
        return ResponseEntity.ok(tickets);
    }

    // Retrieve a specific ticket by ID
    @GetMapping("/{ticketNumber}")
    public ResponseEntity<TicketModel> getTicketById(@PathVariable String ticketNumber) {
        Optional<TicketModel> ticket = ticketRepository.findById(ticketNumber);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing ticket
    @PutMapping("/{ticketNumber}")
    public ResponseEntity<TicketModel> updateTicket(@PathVariable String ticketNumber, @RequestBody TicketModel updatedTicket) {
        if (ticketRepository.existsById(ticketNumber)) {
            updatedTicket.setTicketNumber(ticketNumber); // Ensure the correct ID is set
            TicketModel updated = ticketRepository.save(updatedTicket); // Update the ticket in the database
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a ticket by ID
    @DeleteMapping("/{ticketNumber}")
    public ResponseEntity<Void> deleteTicket(@PathVariable String ticketNumber) {
        if (ticketRepository.existsById(ticketNumber)) {
            ticketRepository.deleteById(ticketNumber); // Delete the ticket from the database
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
