package com.example.traininapp.ChallengePack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ChallengeService {
    private ChallengeRepo challengeRepo;

    @Autowired
    public ChallengeService(ChallengeRepo challengeRepo) {
        this.challengeRepo = challengeRepo;
    }
    public List<Challenge> getAllChallenges(){
        return challengeRepo.findAll();
    }
    public Optional<Challenge> getRandomChallenge() {
        Random rand = new Random();
        Long randomId = rand.nextLong(1, getAllChallenges().size());
        return challengeRepo.findById(randomId);
    }

}
