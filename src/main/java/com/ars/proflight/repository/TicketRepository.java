package com.ars.proflight.repository;

import com.ars.proflight.model.TicketModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<TicketModel, String> {

}