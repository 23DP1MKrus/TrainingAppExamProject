package com.example.traininapp.ExercisePack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ExerciseConfig {
    @Bean
    CommandLineRunner commandLineRunner(ExercicesRepo exerciseRepo) {
        return args -> {
            Exercise exercise1 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Start in a plank position with hands shoulder-width apart. Lower your body until your chest nearly touches the ground, then push back up to the starting position. Keep your core engaged and body straight throughout.",
                    "Push-Up"
            );

            Exercise exercise2 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Stand with feet shoulder-width apart. Lower your hips by bending your knees and pushing your hips back as if sitting in a chair. Keep your chest up and weight on your heels. Return to standing by pushing through your heels.",
                    "Squat"
            );

            Exercise exercise3 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Grip a pull-up bar with palms facing away, hands slightly wider than shoulder-width. Pull yourself up by engaging your back and arms until your chin is above the bar. Lower yourself back down in a controlled manner.",
                    "Pull-Up"
            );

            Exercise exercise4 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Hold a barbell or dumbbells at shoulder height. Press the weight straight up until your arms are fully extended overhead. Slowly lower it back to the starting position.",
                    "Overhead Press"
            );

            Exercise exercise5 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Lie face down and prop yourself up on your forearms with elbows under shoulders. Keep your body in a straight line from head to heels. Engage your core and hold the position without letting your hips drop.",
                    "Plank"
            );

            Exercise exercise6 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Stand in front of a sturdy box or platform. Lower into a slight squat, then jump onto the box, landing softly with knees slightly bent. Step down and repeat.",
                    "Box Jump"
            );

            Exercise exercise7 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Stand on one leg with the other extended forward. Lower your body by bending the supporting leg while keeping the extended leg off the ground. Push back up to the starting position.",
                    "Pistol Squat"
            );

            Exercise exercise8 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Grip parallel bars and lift your body with arms fully extended. Lower yourself until your upper arms are parallel to the floor, then push back up.",
                    "Dips"
            );

            Exercise exercise9 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Start in a standing position, drop into a squat with hands on the ground, kick your feet back into a push-up position, do a push-up, jump your feet back, and explosively jump up.",
                    "Burpee"
            );

            Exercise exercise10 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Grip a bar overhead and hang with arms fully extended. Keep shoulders engaged and hold for as long as possible without swinging.",
                    "Dead Hang"
            );
            Exercise exercise11 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Perform a push-up but explosively push off the ground so that your hands leave the surface, clapping before landing back in push-up position.",
                    "Clap Push-Up"
            );

            Exercise exercise12 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Stand with feet hip-width apart, grip a barbell with a straight back, and lift it by driving through your legs. Keep the bar close to your body and stand fully upright before lowering.",
                    "Deadlift"
            );

            Exercise exercise13 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Start with a pull-up but use explosive strength to bring your chest above the bar, then transition by pushing yourself over the bar and extending your arms.",
                    "Muscle-Up"
            );

            Exercise exercise14 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Lie on your back and extend your legs straight. Lift them up to a 90-degree angle without swinging, then slowly lower them back down while keeping your core engaged.",
                    "Leg Raises"
            );

            Exercise exercise15 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Lie on a bench with feet planted on the ground. Grip the barbell with hands slightly wider than shoulder-width, lower it to your chest, and push it back up.",
                    "Bench Press"
            );

            Exercise exercise16 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Hold the jump rope handles and swing the rope over your head. Jump with both feet as the rope passes under. Maintain a steady rhythm.",
                    "Jump Rope"
            );

            Exercise exercise17 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Sit on the floor with knees bent and feet elevated. Hold a weight with both hands and rotate your torso from side to side, touching the weight to the floor each time.",
                    "Russian Twist"
            );

            Exercise exercise18 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Find a steep hill and sprint up as fast as possible, then walk or jog back down to recover. Repeat for multiple rounds.",
                    "Hill Sprints"
            );

            Exercise exercise19 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Step forward with one foot and lower your back knee toward the ground, keeping the front knee at 90 degrees. Push back to the starting position and switch legs.",
                    "Lunges"
            );

            Exercise exercise20 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Similar to a pull-up, but with palms facing towards you. Pull yourself up until your chin clears the bar and lower yourself back down.",
                    "Chin-Up"
            );

            Exercise exercise21 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Perform a squat, then jump explosively into the air. Land softly and go straight into the next squat.",
                    "Jump Squat"
            );

            Exercise exercise22 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Hold a barbell at shoulder level, perform a deep squat, then explosively push the bar overhead as you stand up.",
                    "Thruster"
            );

            Exercise exercise23 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Lie on your back, lift your legs and shoulders off the ground, and hold the position while keeping your lower back flat on the floor.",
                    "Hollow Body Hold"
            );

            Exercise exercise24 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Hold a barbell with a slight bend in your knees. Hinge at the hips and lower the bar down your legs while keeping your back straight. Stand back up.",
                    "Romanian Deadlift"
            );

            Exercise exercise25 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Bend at the hips and knees slightly, hold a barbell, and row it toward your lower chest while keeping elbows close to your body.",
                    "Barbell Row"
            );

            Exercise exercise26 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Sit on a rowing machine, push with your legs, lean back slightly, and pull the handle towards your chest. Extend your arms and return to the start.",
                    "Rowing"
            );

            Exercise exercise27 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Hold gymnastic rings and push yourself up like a dip, keeping your body stable and controlled throughout.",
                    "Ring Dips"
            );

            Exercise exercise28 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Rest one foot on a bench behind you and perform a lunge, lowering your back knee toward the floor. Push back up using the front leg.",
                    "Bulgarian Split Squat"
            );

            Exercise exercise29 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Lie on your side with your elbow under your shoulder and lift your hips off the ground, keeping your body in a straight line.",
                    "Side Plank"
            );

            Exercise exercise30 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Attach a resistance band to a high anchor, pull the band towards your face while keeping your elbows high and wide.",
                    "Face Pull"
            );

            Exercise exercise31 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Swing a kettlebell between your legs and explosively drive your hips forward, allowing the kettlebell to swing up to chest height.",
                    "Kettlebell Swing"
            );

            Exercise exercise32 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Lie flat on the floor, extend your arms and legs, then lift both simultaneously, reaching for your toes in a V-shape motion.",
                    "V-Ups"
            );

            Exercise exercise33 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Attach a resistance band at elbow height, keep your elbow tucked, and rotate your hand outward while keeping your arm stable.",
                    "Band Shoulder External Rotation"
            );

            Exercise exercise34 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Step sideways into a lunge position, keeping the non-working leg straight. Push back to the starting position.",
                    "Lateral Lunges"
            );

            Exercise exercise35 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Press your back against a wall and slide down until your thighs are parallel to the ground. Hold the position.",
                    "Wall Sit"
            );

            Exercise exercise36 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Lie on your back, place your feet on a stability ball, and pull it towards you using your hamstrings while keeping your hips lifted.",
                    "Hamstring Curl (Swiss Ball)"
            );

            Exercise exercise37 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Hold heavy weights in each hand and walk while keeping your posture upright and core engaged.",
                    "Farmer's Walk"
            );

            Exercise exercise38 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Hold a weight at one side, twist your torso, and bring it across your body in a diagonal chopping motion.",
                    "Woodchopper"
            );

            Exercise exercise39 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Sit on a leg press machine, place your feet shoulder-width apart, and push the platform away from you.",
                    "Leg Press"
            );

            Exercise exercise40 = new Exercise(
                    new ArrayList<>(),
                    null,
                    "Perform a push-up while extending one arm to the side, alternating arms with each repetition.",
                    "Archer Push-Up"
            );
            exerciseRepo.saveAll(List.of(exercise1,exercise2,exercise3,exercise4,exercise5,exercise6,exercise7,exercise8,exercise9,exercise10,
                    exercise11,exercise12,exercise13,exercise14,exercise15,exercise16,exercise17,exercise18,exercise19,exercise20,
                    exercise21,exercise22,exercise23,exercise24,exercise25,exercise26,exercise27,exercise28,exercise29,exercise30,
                    exercise31,exercise32,exercise33,exercise34,exercise35,exercise36,exercise37,exercise38,exercise39,exercise40));
        };
    }
}
