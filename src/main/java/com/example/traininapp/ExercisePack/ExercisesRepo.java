package com.example.traininapp.ExercisePack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExercisesRepo extends JpaRepository<Exercise, Long> {
    @Query
    Optional<Exercise> findById(long id);
}
