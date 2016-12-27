package com.maakesbe.services.controllers;

import com.maakesbe.services.models.Event;
import com.maakesbe.services.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventsController {

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

    @PostMapping("/events")
    public Event createEvent(@RequestBody Event event) {
        return repo.save(event);
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
