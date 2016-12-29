package com.maakesbe.services.controllers;

import com.maakesbe.services.models.Pottery;
import com.maakesbe.services.repositories.PotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PotteryController {

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
        System.out.println("Is this endpoint ever hit?");
        return repo.save(pottery);
    }

    @PutMapping("/pottery")
    public Pottery updatePottery(@RequestBody Pottery pottery) {
        return repo.save(pottery);
    }

    @DeleteMapping("/pottery/{id}")
    public void deletePottery(@PathVariable("id") Long id) {
        repo.delete(id);
    }
}
