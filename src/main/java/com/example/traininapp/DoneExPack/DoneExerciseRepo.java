package com.example.traininapp.DoneExPack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneExerciseRepo extends JpaRepository<DoneExercise, Long> {
    // TODO: Create required queries
}
