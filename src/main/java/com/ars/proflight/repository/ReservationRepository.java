package com.ars.proflight.repository;


import com.ars.proflight.model.ReservationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<ReservationModel, String> {
}