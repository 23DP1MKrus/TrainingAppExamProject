package com.example.traininapp.WorkoutPack;

import com.example.traininapp.DoneExPack.DoneExercise;
import com.example.traininapp.UserPack.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Workout")
@Getter
@Setter
@ToString
public class Workout {
    @Id
    @SequenceGenerator(
            name = "workout_sequence",
            sequenceName = "workout_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workout_sequence"
    )
    private Long id;



    private String name;
    private Time timeSpent;
    private LocalDate date;
    private Integer avgHeartRate;
    private float burntKcal;
    @OneToMany(mappedBy = "workout")
    private List<DoneExercise> doneExercises;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User workoutOwner;

    public Workout(Long id, String name, Time timeSpent, LocalDate date, Integer avgHeartRate, float burntKcal, List<DoneExercise> doneExercises, User workoutOwner) {
        this.id = id;
        this.name = name;
        this.timeSpent = timeSpent;
        this.date = date;
        this.avgHeartRate = avgHeartRate;
        this.burntKcal = burntKcal;
        this.doneExercises = doneExercises;
        this.workoutOwner = workoutOwner;
    }

    public Workout(User workoutOwner, List<DoneExercise> doneExercises, float burntKcal, Integer avgHeartRate, LocalDate date, Time timeSpent, String name) {
        this.workoutOwner = workoutOwner;
        this.doneExercises = doneExercises;
        this.burntKcal = burntKcal;
        this.avgHeartRate = avgHeartRate;
        this.date = date;
        this.timeSpent = timeSpent;
        this.name = name;
    }

    public Workout() {

    }
}
