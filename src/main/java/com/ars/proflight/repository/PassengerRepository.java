package com.ars.proflight.repository;

import com.ars.proflight.model.PassengerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<PassengerModel,String> {
}
