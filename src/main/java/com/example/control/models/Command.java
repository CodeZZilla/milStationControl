package com.example.control.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "command")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String command;

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL)
    private Set<Unit> units;

    @Override
    public String toString() {
        return command;
    }
}
