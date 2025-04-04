package com.example.traininapp.DoneExPack;

import com.example.traininapp.ExercisePack.Exercise;
import com.example.traininapp.WorkoutPack.Workout;
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
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;



    private int reps;
    private int sets;

    public DoneExercise(Long id, Exercise exercise, Workout workout, int reps, int sets) {
        this.id = id;
        this.exercise = exercise;
        this.workout = workout;
        this.reps = reps;
        this.sets = sets;
    }

    public DoneExercise(int sets, int reps, Workout workout, Exercise exercise) {
        this.sets = sets;
        this.reps = reps;
        this.workout = workout;
        this.exercise = exercise;
    }

    public DoneExercise() {
    }
}
