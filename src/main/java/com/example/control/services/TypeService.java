package com.example.control.services;

import com.example.control.models.Type;
import com.example.control.repositories.TypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private TypeRepo repo;

    public TypeService(TypeRepo repo) {
        this.repo = repo;
    }

    public List<Type> findAll() {
        return repo.findAll();
    }
}
