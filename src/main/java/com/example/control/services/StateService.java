package com.example.control.services;

import com.example.control.models.State;
import com.example.control.repositories.StateRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private StateRepo repo;

    public StateService(StateRepo repo) {
        this.repo = repo;
    }

    public List<State> findAll() {
        return repo.findAll();
    }
}
