package com.example.traininapp.PlanPack;

import com.example.traininapp.WorkoutPack.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private final PlansRepo planRepo;
    @Autowired
    public PlanService(PlansRepo planRepo) {this.planRepo = planRepo;}

    public List<Plans> getAllPlans() {
        return planRepo.findAll();
    }

    public Optional<Plans> findAllByDaysCount(Integer daysCount) {
        return planRepo.findAllByDaysCount(daysCount);
    }
    public Optional<Plans> findAllByDifficulty(String difficulty) {
        return planRepo.findAllByDifficulty(difficulty);
    }

    public Plans getPlan(Long Id) {
        Optional<Plans> planOpt = planRepo.findById(Id);
        return planOpt.orElse(null);
    }

    public void addWorkout(Workout workout, Long userId) {
        Plans plan = planRepo.findById(userId).orElseThrow(() -> new IllegalStateException("No such plan found"));
        plan.getWorkouts().add(workout);
        workout.setPlan(plan);
    }

}
