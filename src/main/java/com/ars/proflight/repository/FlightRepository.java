package com.ars.proflight.repository;

import com.ars.proflight.model.FlightModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<FlightModel, String> {

}