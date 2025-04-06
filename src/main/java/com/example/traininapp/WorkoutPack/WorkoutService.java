package com.example.traininapp.WorkoutPack;


import com.example.traininapp.DoneExPack.DoneExercise;
import com.example.traininapp.UserPack.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private WorkoutRepo workoutRepo;
    @Autowired
    public WorkoutService(WorkoutRepo workoutRepo) {
        this.workoutRepo = workoutRepo;
    }

    public List<Workout> getWorkouts() {
        return workoutRepo.findAll();
    }
    public void addWorkout(Workout workout) {
        workoutRepo.save(workout);
    }

    public void addDoneEx(DoneExercise doneExercise, Long workoutId) {
        Workout workout = workoutRepo.findById(workoutId).orElseThrow(() -> new IllegalStateException("No such user found"));
        workout.getDoneExercises().add(doneExercise);
        doneExercise.setWorkout(workout);
    }
}
