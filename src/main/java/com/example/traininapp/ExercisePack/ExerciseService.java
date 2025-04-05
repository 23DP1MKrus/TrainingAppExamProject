package com.example.traininapp.ExercisePack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExercicesRepo exerciseRepo;

    @Autowired
    public ExerciseService(ExercicesRepo exerciseRepo) {this.exerciseRepo = exerciseRepo;}

    public List<Exercise> getAllExercises() {
        return exerciseRepo.findAll();
    }

    public Exercise getExercise(Long Id) {
        Optional<Exercise> exerciseOpt = exerciseRepo.findById(Id);
        return exerciseOpt.orElse(null);
    }

}
