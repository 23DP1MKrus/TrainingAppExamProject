package com.example.traininapp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @OneToMany(mappedBy = "workoutOwner")
    private List<Workout> workouts;


    public User(Long id, String name, String surname, String email, String password, List<Workout> workouts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.workouts = workouts;
    }

    public User(List<Workout> workouts, String password, String email, String surname, String name) {
        this.workouts = workouts;
        this.password = password;
        this.email = email;
        this.surname = surname;
        this.name = name;
    }

    public User() {

    }
}
