package com.maakesbe.services.repositories;


import com.maakesbe.services.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
