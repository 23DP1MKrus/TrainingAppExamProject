package com.example.traininapp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

@Entity
@Table(name = "exercices")
@Getter
@Setter
public class Exercices {
    @Id
    @SequenceGenerator(
            name = "exercices_sequence",
            sequenceName = "exercices_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercices_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private VarbinaryJdbcType image;

    public Exercices(Long id, String name, String description, VarbinaryJdbcType image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Exercices(String name, String description, VarbinaryJdbcType image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Exercices() {

    }
}
