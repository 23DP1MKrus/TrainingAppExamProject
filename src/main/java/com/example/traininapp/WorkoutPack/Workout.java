package com.example.traininapp.WorkoutPack;

import com.example.traininapp.DoneExPack.DoneExercise;
import com.example.traininapp.PlanPack.Plans;
import com.example.traininapp.UserPack.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private LocalTime timeSpent;
    private LocalDate date;
    private Integer avgHeartRate;
    private float burntKcal;
    @OneToMany(mappedBy = "workout")
    private List<DoneExercise> doneExercises;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User workoutOwner;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plans plan;

    public Workout(Long id, String name, LocalTime timeSpent, LocalDate date, Integer avgHeartRate, float burntKcal, List<DoneExercise> doneExercises, User workoutOwner, Plans plan) {
        this.id = id;
        this.name = name;
        this.timeSpent = timeSpent;
        this.date = date;
        this.avgHeartRate = avgHeartRate;
        this.burntKcal = burntKcal;
        this.doneExercises = doneExercises;
        this.workoutOwner = workoutOwner;
        this.plan = plan;
    }

    public Workout(User workoutOwner, List<DoneExercise> doneExercises, float burntKcal, Integer avgHeartRate, LocalDate date, LocalTime timeSpent, String name, Plans plan) {
        this.workoutOwner = workoutOwner;
        this.doneExercises = doneExercises;
        this.burntKcal = burntKcal;
        this.avgHeartRate = avgHeartRate;
        this.date = date;
        this.timeSpent = timeSpent;
        this.name = name;
        this.plan = plan;
    }
    public Workout() {

    }
}
