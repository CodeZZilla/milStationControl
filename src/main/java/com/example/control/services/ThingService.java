package com.example.control.services;


import com.example.control.models.Thing;
import com.example.control.repositories.ThingRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThingService {

    private final ThingRepo thingRepo;

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

    public List<Thing> findAllByIdUnit(Long id) {
        return thingRepo.findAll().stream().filter(x -> x.getUnit().getId().equals(id)).collect(Collectors.toList());
    }
}
