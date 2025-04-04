package com.example.traininapp.UserPack;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final String pattern = "^(?=(?:.*[A-Z]){2,})(?=(?:.*[a-z]){2,})(?=(?:.*\\d){2,})(?=(?:.*[^a-zA-Z\\d]){1,}).{7,}$";
    private UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {this.userRepo = userRepo;}

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public void addUser(User user) {
        Optional<User> userOpt = userRepo.findByEmail(user.getEmail());
        if (userOpt.isPresent()) {
            throw new IllegalStateException("User with email " + user.getEmail() + " already exists");
        } else if (!user.getPassword().matches(pattern)) {
            throw new IllegalStateException("Your password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, no whitespace and be at least 8 characters");
        }
        else {
            userRepo.save(user);
        }

    }

    public boolean canLogin(String email) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent()) {
            return true;
        }
        else{
            throw new IllegalStateException("User with email " + email + " does not exist or email is not valid");
        }
}
}
