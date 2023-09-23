package com.ars.proflight.controller;

import com.ars.proflight.model.PassengerModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passenger")
@Tag(name = "Passenger")
public class PassengerController {

    @Autowired
    PassengerRepository repo;

    @GetMapping
    public List<PassengerModel> get(){ return repo.findAll();}

}
