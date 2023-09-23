package com.ars.proflight.controller;

import com.ars.proflight.model.PassengerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<PassengerModel,String> {
}
