package com.example.traininapp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "doneExercises")
@Getter
@Setter
@ToString
public class DoneExercise {
    @Id
    @SequenceGenerator(
            name = "doneExercise_sequence",
            sequenceName = "doneExercise_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doneExercise_sequence"
    )
    private Long id;
    // TODO: Create foreign keys
    private int reps;
    private int sets;

    // TODO: Create three constructors
}
