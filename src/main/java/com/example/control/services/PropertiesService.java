package com.example.control.services;

import com.example.control.models.Properties;
import com.example.control.models.Thing;
import com.example.control.repositories.PropertiesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertiesService {

    private PropertiesRepo propertiesRepo;

    public PropertiesService(PropertiesRepo propertiesRepo) {
        this.propertiesRepo = propertiesRepo;
    }

    public List<Properties> findAll(){
        return propertiesRepo.findAll();
    }

    public void save (Properties properties) {
        propertiesRepo.save(properties);
    }

    public Properties findById(Long id) {
        return propertiesRepo.findById(id).get();
    }

    public void deleteById(Long id) {
        propertiesRepo.deleteById(id);
    }
}

