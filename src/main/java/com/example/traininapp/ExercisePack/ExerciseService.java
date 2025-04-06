package com.example.traininapp.ExercisePack;

import com.example.traininapp.DoneExPack.DoneExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    private ExercisesRepo exercisesRepo;
    @Autowired
    public ExerciseService(ExercisesRepo exercisesRepo) {
        this.exercisesRepo = exercisesRepo;
    }
    public List<Exercise> getAllExercises(){
        return exercisesRepo.findAll();
    }

    public void addDoneExercise(DoneExercise doneExercise, Long exerciseId) {
        Exercise exercise = exercisesRepo.findById(exerciseId).orElseThrow(() -> new IllegalStateException("Exercise not found"));
        exercise.getDoneExercises().add(doneExercise);
        doneExercise.setExercise(exercise);
    }
}
