package com.example.control.services;


import com.example.control.models.Thing;
import com.example.control.repositories.ThingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingService {

    private ThingRepo thingRepo;

    public ThingService(ThingRepo thingRepo) {
        this.thingRepo = thingRepo;
    }

    public List<Thing> findAll() {
        return thingRepo.findAll();
    }

    public void save (Thing thing) {
        thingRepo.save(thing);
    }

    public Thing findById(Long id) {
        return thingRepo.findById(id).get();
    }

    public void deleteById(Long id) {
        thingRepo.deleteById(id);
    }
}
