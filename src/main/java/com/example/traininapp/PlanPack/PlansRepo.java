package com.example.traininapp.PlanPack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlansRepo extends JpaRepository<Plans, Long> {

}
