package com.example.control.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "thing")
@Data
@NoArgsConstructor
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Properties properties;

    private Double price;
    private Integer category;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Thing parentThing;
    @OneToMany(mappedBy="parentThing")
    private Set<Thing> things;

    @ManyToOne
    private Unit unit;
}
