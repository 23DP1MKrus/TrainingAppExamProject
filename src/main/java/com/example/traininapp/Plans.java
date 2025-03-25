package com.example.traininapp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "plans")
@Getter
@Setter
@ToString
public class Plans {
    @Id
    @SequenceGenerator(
            name = "plans_sequence",
            sequenceName = "plans_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plans_sequence"
    )
    private Long id;
    private String name;
    private String difficulty;
    private Integer daysCount;
    @OneToMany(mappedBy = "plan")
    private List<DoneExercise> doneExercises;

    public Plans(Long id, String name, String difficulty, Integer daysCount) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.daysCount = daysCount;
    }

    public Plans(String name, String difficulty, Integer daysCount) {
        this.name = name;
        this.difficulty = difficulty;
        this.daysCount = daysCount;
    }

    public Plans() {
    }
}
