package com.example.traininapp.ChallengePack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChallengeConfig {
   @Bean
   CommandLineRunner commandLineRunner(ChallengeRepo challengeRepo) {
       return args -> {
           Challenge challenge1 = new Challenge(
                   false,
                   "100 Push-Ups a Day",
                   "Do 100 push-ups every day for 30 days."
           );

           Challenge challenge2 = new Challenge(
                   false,
                   "Plank Challenge",
                   "Increase your plank time daily, aiming for 5 minutes by the end of the month."
           );

           Challenge challenge3 = new Challenge(
                   false,
                   "10K Steps Daily",
                   "Walk or run at least 10,000 steps every day for a month."
           );

           Challenge challenge4 = new Challenge(
                   false,
                   "One-Arm Push-Up Mastery",
                   "Train progressively to achieve a one-arm push-up in 60 days."
           );

           Challenge challenge5 = new Challenge(
                   false,
                   "Pull-Up Progression",
                   "Improve your pull-up count by doing them daily for 4 weeks."
           );

           Challenge challenge6 = new Challenge(
                   false,
                   "Handstand Challenge",
                   "Train daily to hold a 30-second freestanding handstand within a month."
           );

           Challenge challenge7 = new Challenge(
                   false,
                   "Squat Challenge",
                   "Perform 250 bodyweight squats daily for 30 days."
           );

           Challenge challenge8 = new Challenge(
                   false,
                   "Core Strength Challenge",
                   "Do a combination of abs exercises for 10 minutes daily for 30 days."
           );

           Challenge challenge9 = new Challenge(
                   false,
                   "Dead Hang Challenge",
                   "Increase your dead hang duration by training daily."
           );

           Challenge challenge10 = new Challenge(
                   false,
                   "Burpee Madness",
                   "Perform 50 burpees daily for 30 days."
           );

           Challenge challenge11 = new Challenge(
                   false,
                   "Jump Rope Challenge",
                   "Jump rope for 10 minutes every day for a month."
           );

           Challenge challenge12 = new Challenge(
                   false,
                   "Sprint Challenge",
                   "Do 5 sets of 100m sprints three times a week for a month."
           );

           Challenge challenge13 = new Challenge(
                   false,
                   "Yoga Flexibility Challenge",
                   "Stretch and practice yoga for 15 minutes daily for 30 days."
           );

           Challenge challenge14 = new Challenge(
                   false,
                   "No Sugar Challenge",
                   "Avoid all processed sugar for 30 days while maintaining your workout routine."
           );

           Challenge challenge15 = new Challenge(
                   false,
                   "Weighted Vest Training",
                   "Train with a weighted vest 3 times a week to improve strength and endurance."
           );

           Challenge challenge16 = new Challenge(
                   false,
                   "Calisthenics Flow",
                   "Perform a full-body calisthenics workout daily for a month."
           );

           Challenge challenge17 = new Challenge(
                   false,
                   "One-Leg Squat (Pistol Squat) Challenge",
                   "Train to achieve at least 5 pistol squats per leg in 60 days."
           );

           Challenge challenge18 = new Challenge(
                   false,
                   "Morning Cold Showers",
                   "Take a cold shower every morning to boost recovery and discipline."
           );

           Challenge challenge19 = new Challenge(
                   false,
                   "Muscle-Up Challenge",
                   "Train to complete your first muscle-up within 45 days."
           );

           Challenge challenge20 = new Challenge(
                   false,
                   "Run a Half-Marathon",
                   "Train progressively to run a half-marathon in 8 weeks."
           );
           challengeRepo.saveAll(List.of(challenge1,challenge2,challenge3,challenge4,challenge5,challenge6,challenge7,challenge8,challenge9,challenge10,challenge11,challenge12,challenge13,challenge14,challenge15,challenge16,challenge17,challenge18,challenge19,challenge20));
       };
   }

}
