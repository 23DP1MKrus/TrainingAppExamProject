package com.example.traininapp.ChallengePack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChallengeConfig {
   @Bean
   CommandLineRunner commandLineRunner1(ChallengeRepo challengeRepo) {
       return args -> {
           Challenge challenge1 = new Challenge(
                   false,
                   "Do 100 push-ups every day for 30 days.",
                   "100 Push-Ups a Day"
           );

           Challenge challenge2 = new Challenge(
                   false,
                   "Increase your plank time daily, aiming for 5 minutes by the end of the month.",
                   "Plank Challenge"
           );

           Challenge challenge3 = new Challenge(
                   false,
                   "Walk or run at least 10,000 steps every day for a month.",
                   "10K Steps Daily"

           );

           Challenge challenge4 = new Challenge(
                   false,
                   "Train progressively to achieve a one-arm push-up in 60 days.",
                   "One-Arm Push-Up Mastery"

           );

           Challenge challenge5 = new Challenge(
                   false,
                   "Improve your pull-up count by doing them daily for 4 weeks.",
                   "Pull-Up Progression"

           );

           Challenge challenge6 = new Challenge(
                   false,
                   "Train daily to hold a 30-second freestanding handstand within a month.",
                   "Handstand Challenge"
           );

           Challenge challenge7 = new Challenge(
                   false,
                   "Perform 250 bodyweight squats daily for 30 days.",
                   "Squat Challenge"

           );

           Challenge challenge8 = new Challenge(
                   false,
                   "Do a combination of abs exercises for 10 minutes daily for 30 days.",
                   "Core Strength Challenge"

           );

           Challenge challenge9 = new Challenge(
                   false,
                   "Increase your dead hang duration by training daily.",
                   "Dead Hang Challenge"

           );

           Challenge challenge10 = new Challenge(
                   false,
                   "Perform 50 burpees daily for 30 days.",
                   "Burpee Madness"

           );

           Challenge challenge11 = new Challenge(
                   false,
                   "Jump rope for 10 minutes every day for a month.",
                   "Jump Rope Challenge"

           );

           Challenge challenge12 = new Challenge(
                   false,
                   "Do 5 sets of 100m sprints three times a week for a month.",
                   "Sprint Challenge"

           );

           Challenge challenge13 = new Challenge(
                   false,
                   "Stretch and practice yoga for 15 minutes daily for 30 days.",
                   "Yoga Flexibility Challenge"

           );

           Challenge challenge14 = new Challenge(
                   false,
                   "Avoid all processed sugar for 30 days while maintaining your workout routine.",
                   "No Sugar Challenge"

           );

           Challenge challenge15 = new Challenge(
                   false,
                   "Train with a weighted vest 3 times a week to improve strength and endurance.",
                   "Weighted Vest Training"

           );

           Challenge challenge16 = new Challenge(
                   false,
                   "Perform a full-body calisthenics workout daily for a month.",
                   "Calisthenics Flow"

           );

           Challenge challenge17 = new Challenge(
                   false,
                   "Train to achieve at least 5 pistol squats per leg in 60 days.",
                   "One-Leg Squat (Pistol Squat) Challenge"

           );

           Challenge challenge18 = new Challenge(
                   false,
                   "Take a cold shower every morning to boost recovery and discipline.",
                   "Morning Cold Showers"

           );

           Challenge challenge19 = new Challenge(
                   false,
                   "Train to complete your first muscle-up within 45 days.",
                   "Muscle-Up Challenge"

           );

           Challenge challenge20 = new Challenge(
                   false,
                   "Train progressively to run a half-marathon in 8 weeks.",
                   "Run a Half-Marathon"

           );
           challengeRepo.saveAll(List.of(challenge1,challenge2,challenge3,challenge4,challenge5,challenge6,challenge7,challenge8,challenge9,challenge10,challenge11,challenge12,challenge13,challenge14,challenge15,challenge16,challenge17,challenge18,challenge19,challenge20));
       };
   }

}
