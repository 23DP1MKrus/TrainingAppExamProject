package com.example.traininapp.Views;

import com.example.traininapp.ExercisePack.Exercise;
import com.example.traininapp.ExercisePack.ExerciseService;
import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.PlanPack.PlansRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("exercises")
public class ExercisesView extends Div {
    private final ExerciseService exerciseService;
    public ExercisesView(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
        setId("exercises-view");

        Div workoutDiv = new Div();
        workoutDiv.setId("exercise-main-div");

        VerticalLayout leftContainer = new VerticalLayout();
        leftContainer.setId("left-container");
        Image logo = new Image();
        logo.setClassName("logo");

        leftContainer.add(logo);
        leftContainer.add(
                new Anchor("plans","PLANS"),
                new Anchor("main","MAIN"),
                new Anchor("workouts","WORKOUTS"),
                new Anchor("exercises","EXERCISES")
        );


        HorizontalLayout topContainer = new HorizontalLayout();
        topContainer.setId("top-container");
        H1 title = new H1("EXERCISES");
        title.setClassName("title");
        Button logWorkout = new Button("log workout");

        logWorkout.setClassName("log-workout-button");
        Image searchIcon = new Image();
        Button searchBtn = new Button(searchIcon);
        searchBtn.setClassName("topBtn");
        Image ringIcon = new Image();
        Button ringBtn = new Button(ringIcon);
        ringBtn.setClassName("topBtn");
        Image profileIcon = new Image();
        Button profileBtn = new Button(profileIcon);
        profileBtn.setClassName("topBtn");

        logWorkout.addClickListener(e -> {
            UI.getCurrent().navigate("logWorkout");
        });

        topContainer.add(title, logWorkout,searchBtn, ringBtn, profileBtn);

        VerticalLayout middleContainer = new VerticalLayout();
        middleContainer.setId("middle-container");
        List<Exercise> exerciseList = exerciseService.getAllExercises();
        for (Exercise exercise : exerciseList) {
            HorizontalLayout exerciseContainer = new HorizontalLayout();
            exerciseContainer.setId("exercise-container");
            Div line = new Div();
            line.setClassName("line");
            VerticalLayout exTextContainer = new VerticalLayout();
            H1 exerciseName = new H1(exercise.getName());
            exerciseName.setClassName("exercise-name");
            Paragraph exerciseDescription = new Paragraph(exercise.getDescription());
            exTextContainer.add(exerciseName, exerciseDescription);
            Image exerciseImage = new Image(exercise.getImage(), exercise.getName());
            exerciseImage.setClassName("exercise-image");
            exerciseContainer.add(line,exTextContainer,exerciseImage);
            middleContainer.add(exerciseContainer);
        }
    add(leftContainer,topContainer,middleContainer);
    }
}
