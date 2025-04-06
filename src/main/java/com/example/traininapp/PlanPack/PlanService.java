package com.example.traininapp.PlanPack;

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

    public Plans getPlan(Long Id) {
        Optional<Plans> planOpt = planRepo.findById(Id);
        return planOpt.orElse(null);
    }

}
