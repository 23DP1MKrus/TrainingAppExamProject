package com.example.traininapp.ExercisePack;

import com.example.traininapp.DoneExPack.DoneExercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

import java.util.List;

@Entity
@Table(name = "exercices")
@Getter
@Setter
@ToString
public class Exercices {
    @Id
    @SequenceGenerator(
            name = "exercices_sequence",
            sequenceName = "exercices_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercices_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private VarbinaryJdbcType image;
    @OneToMany(mappedBy = "exercise")
    private List<DoneExercise> doneExercises;

    public Exercices(Long id, String name, String description, VarbinaryJdbcType image, List<DoneExercise> doneExercises) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.doneExercises = doneExercises;
    }

    public Exercices(List<DoneExercise> doneExercises, VarbinaryJdbcType image, String description, String name) {
        this.doneExercises = doneExercises;
        this.image = image;
        this.description = description;
        this.name = name;
    }

    public Exercices() {

    }
}
