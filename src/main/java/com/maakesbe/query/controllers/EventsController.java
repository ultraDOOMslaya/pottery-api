package com.maakesbe.query.controllers;

import com.maakesbe.query.models.Event;
import com.maakesbe.query.repositories.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventsController {

    private static final Logger log = LoggerFactory.getLogger(EventsController.class);

    @Autowired
    EventRepository repo;

    @GetMapping("/events")
    public Iterable getEvents() {
        return repo.findAll();
    }

    @GetMapping("/events/{id}")
    public Event getOneEvent(@PathVariable("id") Long id) {
        return repo.findOne(id);
    }

    @PutMapping("/events")
    public Event updateEvent(@RequestBody Event event) {
        return repo.save(event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        repo.delete(id);
    }
}
