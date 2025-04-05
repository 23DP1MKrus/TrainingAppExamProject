package com.example.traininapp.ExercisePack;

import com.example.traininapp.DoneExPack.DoneExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private ExercicesRepo exercicesRepo;
    @Autowired
    public ExerciseService(ExercicesRepo exercicesRepo) {
        this.exercicesRepo = exercicesRepo;
    }
    public List<Exercise> getAllExercises(){
        return exercicesRepo.findAll();
    }

    public void addDoneExercise(DoneExercise doneExercise, Long exerciseId) {
        Exercise exercise = exercicesRepo.findById(exerciseId).orElseThrow(() -> new IllegalStateException("Exercise not found"));
        exercise.getDoneExercises().add(doneExercise);
        doneExercise.setExercise(exercise);
    }
}
