package com.example.control.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "unit")
@Data
@NoArgsConstructor
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameUnit;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Command command;
//    @OneToMany(mappedBy="command")
//    private Set<Unit> units;

//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    private Unit command;

    @OneToMany(mappedBy = "unit", fetch = FetchType.EAGER)
    private List<Thing> thingList;

    @OneToMany(mappedBy="unit", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<User> users;

    @Override
    public String toString() {
        return nameUnit;
    }
}
