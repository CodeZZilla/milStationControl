package com.example.control.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    private Properties properties = new Properties();

    private Double price;
    private Integer category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    private State state;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Thing parentThing;
    @OneToMany(mappedBy="parentThing", cascade = CascadeType.ALL)
    private List<Thing> things = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Unit unit;

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", properties=" + properties +
                ", price=" + price +
                ", category=" + category +
                ", type=" + type +
                ", state=" + state +
                ", unit=" + unit +
                '}';
    }
}
