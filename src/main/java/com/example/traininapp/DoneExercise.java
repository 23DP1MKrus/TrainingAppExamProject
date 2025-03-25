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

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercices exercise;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plans plan;

    private int reps;
    private int sets;

    public DoneExercise(Long id, Exercices exercise, Workout workout, Plans plan, int reps, int sets) {
        this.id = id;
        this.exercise = exercise;
        this.workout = workout;
        this.plan = plan;
        this.reps = reps;
        this.sets = sets;
    }

    public DoneExercise(int sets, int reps, Plans plan, Workout workout, Exercices exercise) {
        this.sets = sets;
        this.reps = reps;
        this.plan = plan;
        this.workout = workout;
        this.exercise = exercise;
    }

    public DoneExercise() {
    }
}
