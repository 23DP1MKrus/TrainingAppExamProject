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

    public Plans(List<DoneExercise> doneExercises, Integer daysCount, String difficulty, String name, Long id) {
        this.doneExercises = doneExercises;
        this.daysCount = daysCount;
        this.difficulty = difficulty;
        this.name = name;
        this.id = id;
    }

    public Plans(String name, String difficulty, Integer daysCount, List<DoneExercise> doneExercises) {
        this.name = name;
        this.difficulty = difficulty;
        this.daysCount = daysCount;
        this.doneExercises = doneExercises;
    }

    public Plans() {
    }
}
