package com.example.control.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "type")
@Data
@NoArgsConstructor
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Boolean isCompletType;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private List<Thing> thingList;

    @Override
    public String toString() {
        return type;
    }
}
