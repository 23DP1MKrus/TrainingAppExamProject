package com.example.traininapp.PlanPack;


import com.example.traininapp.DoneExPack.DoneExercise;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class PlanConfig {
    @Bean
    CommandLineRunner commandLineRunner(PlansRepo plansRepo) {
        return args -> {
            Plans fullbody = new Plans(
                     "Full Body",
                     "Every day full body workout",
                     "Difficult",
                    3,
                    new ArrayList<>()
);

            Plans pushPullLegs = new Plans(
                    "Push-Pull-Legs",
                    "A balanced routine targeting push, pull, and legs on separate days",
                    "Intermediate",
                     6,
                    new ArrayList<>()
);

            Plans upperLower = new Plans(
                    "Upper-Lower Split",
                   "Alternates between upper body and lower body workouts",
                     "Intermediate",
                     4,
                    new ArrayList<>()
);

            Plans broSplit = new Plans(
                    "Bro Split",
                    "Each muscle group is trained on a separate day",
                    "Beginner",
                     5,
                    new ArrayList<>()
);

            Plans fiveXFive = new Plans(
                     "StrongLifts 5x5",
                    "Focuses on strength with five compound lifts",
                    "Intermediate",
                     3,
                    new ArrayList<>()
);

            Plans crossfit = new Plans(
                   "CrossFit",
                    "High-intensity functional fitness training",
                     "Advanced",
                     5,
                    new ArrayList<>()
);

            Plans calisthenics = new Plans(
                    "Calisthenics",
                     "Bodyweight training for strength and endurance",
                    "Intermediate",
                     5,
                    new ArrayList<>()
);

            Plans hypertrophy = new Plans(
                     "Hypertrophy Training",
                     "Focuses on muscle growth with high volume",
                     "Intermediate",
                     5,
                    new ArrayList<>()
);

            Plans endurance = new Plans(
                     "Endurance Training",
                     "Cardio and high-rep resistance training",
                     "Beginner",
                     4,
                    new ArrayList<>()
);
            plansRepo.saveAll(List.of(upperLower,fullbody,pushPullLegs,broSplit,fiveXFive,endurance,hypertrophy,calisthenics,crossfit));
        };
    }
}
