package com.example.control.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "unit")
@Data
@NoArgsConstructor
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameUnit;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Unit command;

    @OneToMany(mappedBy = "unit", fetch = FetchType.EAGER)
    private List<Thing> thingList;

    @OneToMany(mappedBy="unit")
    private List<User> users;

    @Override
    public String toString() {
        return nameUnit;
    }
}
