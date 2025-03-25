package com.example.traininapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicesRepo extends JpaRepository<Exercices, Long> {
}
