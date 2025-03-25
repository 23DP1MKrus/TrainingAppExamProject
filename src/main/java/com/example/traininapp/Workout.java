package com.example.traininapp;

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

    public Workout(Long id, String name, Time timeSpent, LocalDate date, Integer avgHeartRate, float burntKcal) {
        this.id = id;
        this.name = name;
        this.timeSpent = timeSpent;
        this.date = date;
        this.avgHeartRate = avgHeartRate;
        this.burntKcal = burntKcal;
    }

    public Workout(String name, Time timeSpent, LocalDate date, Integer avgHeartRate, float burntKcal) {
        this.name = name;
        this.timeSpent = timeSpent;
        this.date = date;
        this.avgHeartRate = avgHeartRate;
        this.burntKcal = burntKcal;
    }

    public Workout() {

    }
}
