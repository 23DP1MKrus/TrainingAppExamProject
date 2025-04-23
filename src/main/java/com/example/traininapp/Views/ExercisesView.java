package com.example.traininapp.Views;

import com.example.traininapp.ExercisePack.Exercise;
import com.example.traininapp.ExercisePack.ExerciseService;
import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.PlanPack.PlansRepo;
import com.example.traininapp.Views.Components.LeftNavigation;
import com.example.traininapp.Views.Components.TopBar;
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

        LeftNavigation leftContainer = new LeftNavigation();

        TopBar topContainer = new TopBar("Exercises");

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
