package com.example.traininapp.PlanPack;

import com.example.traininapp.UserPack.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlansRepo extends JpaRepository<Plans, Long> {
    @Query
    Optional<Plans> findAllByDifficulty(String difficulty);

    @Query
    Optional<Plans> findAllByDaysCount(Integer daysCount);
}
