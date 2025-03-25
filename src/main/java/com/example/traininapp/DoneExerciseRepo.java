package com.example.traininapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneExerciseRepo extends JpaRepository<DoneExercise, Long> {
    // TODO: Create required queries
}
