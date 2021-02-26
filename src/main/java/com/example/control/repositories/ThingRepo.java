package com.example.control.repositories;


import com.example.control.models.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepo extends JpaRepository<Thing, Long> {

}
