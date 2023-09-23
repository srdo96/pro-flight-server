package com.ars.proflight.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/passenger")
@Tag(name = "Passenger")
public class PassengerController {
    @GetMapping
    public String get(){ return "Passenger List";}

}
