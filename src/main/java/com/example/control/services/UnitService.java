package com.example.control.services;

import com.example.control.models.Thing;
import com.example.control.models.Unit;
import com.example.control.repositories.UnitRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepo repo;

    public UnitService(UnitRepo repo) {
        this.repo = repo;
    }

    public List<Unit> findAll() {
        return repo.findAll();
    }

    public Unit findById(Long id) {
        return repo.findById(id).get();
    }

}
