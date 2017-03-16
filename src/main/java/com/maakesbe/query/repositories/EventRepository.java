package com.maakesbe.query.repositories;


import com.maakesbe.query.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
