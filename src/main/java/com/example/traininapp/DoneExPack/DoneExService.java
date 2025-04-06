package com.example.traininapp.DoneExPack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoneExService {
    private DoneExerciseRepo doneExerciseRepo;
    @Autowired
    public DoneExService(DoneExerciseRepo doneExerciseRepo) {
        this.doneExerciseRepo = doneExerciseRepo;
    }
    public List<DoneExercise> getAllDoneExercises() {
            return doneExerciseRepo.findAll();
    }
    public void addDoneExercise(DoneExercise doneExercise) {
        doneExerciseRepo.save(doneExercise);
    }


}
