package com.maakesbe.query.controllers;

import com.maakesbe.query.models.PotteryType;
import com.maakesbe.query.repositories.PotteryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PotteryTypeController {

    @Autowired
    PotteryTypeRepository repo;

    @GetMapping("/potteryType")
    public Iterable<PotteryType> potteryType() { return repo.findAll(); }

    @GetMapping("/potteryType/{id}")
    public PotteryType getOnePotteryType(@PathVariable("id") Long id) { return repo.findOne(id); }

    @PutMapping("/potteryType")
    public PotteryType updateEvent(@RequestBody PotteryType potteryType) {
        return repo.save(potteryType);
    }
    
}
