package com.example.control.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity(name = "properties")
@Data
@NoArgsConstructor
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String info;
    private String length;
    private String frequency;
    private String weight;

    @OneToOne(mappedBy = "properties", cascade = CascadeType.ALL)
    private Thing thing;

    @Override
    public String toString() {
        return "Properties{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", length='" + length + '\'' +
                ", frequency='" + frequency + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
