package com.maakesbe.query.controllers;

import com.maakesbe.query.models.Pottery;
import com.maakesbe.query.repositories.PotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PotteryController {

    private static final Logger log = LoggerFactory.getLogger(PotteryController.class);

    @Autowired
    PotteryRepository repo;

    @GetMapping("/pottery")
    public Iterable<Pottery> pottery() {
        return repo.findAll();
    }

    @GetMapping("/pottery/{id}")
    public Pottery getOnePottery(@PathVariable("id") Long id) {
        return repo.findOne(id);
    }

    @PostMapping("/pottery")
    public Pottery createPottery(@RequestBody Pottery pottery) {
        return repo.save(pottery);
    }

    @PutMapping("/pottery")
    public Pottery updatePottery(@RequestBody Pottery pottery) {
        log.info("The pottery data from the client is: {}", pottery);
        return repo.save(pottery);
    }


    @DeleteMapping("/pottery/{id}")
    public void deletePottery(@PathVariable("id") Long id) {
        repo.delete(id);
    }
}
