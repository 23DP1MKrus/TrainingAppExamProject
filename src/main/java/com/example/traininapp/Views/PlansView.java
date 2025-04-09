package com.example.traininapp.Views;


import com.example.traininapp.DoneExPack.DoneExService;
import com.example.traininapp.ExercisePack.Exercise;
import com.example.traininapp.ExercisePack.ExerciseService;
import com.example.traininapp.WorkoutPack.Workout;
import com.example.traininapp.WorkoutPack.WorkoutService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("Plans")
public class PlansView extends Div {
    private final PlansService palnsService;

    @Autowired
    public PlansView(PlansService plansService) {
        this.plansService = plansService;
        setId("plans");

        Div plansDiv = new Div();
        plansDiv.setId("plans-div");

        VerticalLayout leftContainer = new VerticalLayout();
        leftContainer.setId("left-container");
        Image logo = new Image();
        logo.setClassName("logo");

        Paragraph plansAnchorText = new Paragraph("PLANS");
        Anchor anchorPlans = new Anchor("plans");
        anchorPlans.setClassName("nav-link");
        plansAnchorText.setClassName("nav-link-text");
        plansAnchorText.add(anchorPlans);

        Paragraph exerciseAnchorText = new Paragraph("Exercises");
        Anchor linkExercises = new Anchor("exercises");
        linkExercises.setClassName("nav-link");
        exerciseAnchorText.setClassName("nav-link-text");
        exerciseAnchorText.add(linkExercises);

        Paragraph mainAnchorText = new Paragraph("MAIN");
        Anchor anchorMain = new Anchor("main");
        anchorMain.setClassName("nav-link");
        mainAnchorText.setClassName("nav-link-text");
        mainAnchorText.add(anchorMain);

        Paragraph workoutsAnchorText = new Paragraph("WORKOUTS");
        Anchor anchorWorkouts = new Anchor("workouts");
        anchorWorkouts.setClassName("nav-link");
        workoutsAnchorText.setClassName("nav-link-text");
        workoutsAnchorText.add(anchorWorkouts);

        leftContainer.add(logo, plansAnchorText, exerciseAnchorText, mainAnchorText, workoutsAnchorText);

        HorizontalLayout topContainer = new HorizontalLayout();
        topContainer.setId("top-container");
        H1 title = new H1("PLANS");
        title.setClassName("title");

        Image searchIcon = new Image();
        Button searchBtn = new Button(searchIcon);
        searchBtn.setClassName("topBtn");
        Image ringIcon = new Image();
        Button ringBtn = new Button(ringIcon);
        ringBtn.setClassName("topBtn");
        Image profileIcon = new Image();
        Button profileBtn = new Button(profileIcon);
        profileBtn.setClassName("topBtn");
        topContainer.add(title, searchBtn, ringBtn, profileBtn);

        VerticalLayout middleContainer = new VerticalLayout();
        middleContainer.setId("middle-container");

    }