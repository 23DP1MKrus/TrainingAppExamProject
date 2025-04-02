package com.example.traininapp.PlanPack;

import com.example.traininapp.DoneExPack.DoneExercise;
import com.example.traininapp.WorkoutPack.Workout;
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
    private String description;
    private String difficulty;
    private Integer daysCount;
    @OneToMany(mappedBy = "plan")
    private List<Workout> workouts;

    public Plans(List<Workout> workouts, Integer daysCount, String difficulty, String name, Long id,String description) {
        this.workouts = workouts;
        this.daysCount = daysCount;
        this.difficulty = difficulty;
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public Plans(String name, String description ,String difficulty, Integer daysCount, List<Workout> workouts) {
        this.name = name;
        this.difficulty = difficulty;
        this.daysCount = daysCount;
        this.workouts = workouts;
        this.description = description;
    }

    public Plans() {
    }
}
