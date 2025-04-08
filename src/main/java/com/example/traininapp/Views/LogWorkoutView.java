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

@Route("logWorkout")
public class LogWorkoutView extends Div {
   private final WorkoutService workoutService;
   private final ExerciseService exerciseService;
   private final DoneExService doneExService;

   @Autowired
    public LogWorkoutView(WorkoutService workoutService, ExerciseService exerciseService, DoneExService doneExService) {
       this.workoutService = workoutService;
       this.exerciseService = exerciseService;
       this.doneExService = doneExService;
       setId("log-workout");

       Div workoutDiv = new Div();
       workoutDiv.setId("workout-div");

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

       leftContainer.add(logo,plansAnchorText,exerciseAnchorText,mainAnchorText,workoutsAnchorText);

       HorizontalLayout topContainer = new HorizontalLayout();
       topContainer.setId("top-container");
       H1 title = new H1("LOG YOUR RECENT WORKOUT");
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
       topContainer.add(title, logWorkout,searchBtn, ringBtn, profileBtn);

       VerticalLayout middleContainer = new VerticalLayout();
       middleContainer.setId("middle-container");

        VerticalLayout choosePlanContainer = new VerticalLayout();
        choosePlanContainer.setId("choose-plan-container");
        H1 choosePlan = new H1("choose plan");
        choosePlan.setClassName("choose-plan-title");
        Select<String> selectPlan = new Select<>();
        selectPlan.setClassName("select-plan");
        selectPlan.setItems("Full Body","Push-Pull-Legs","Upper-Lower Split","Bro Split","StrongLifts 5x5","CrossFit","Calisthenics","Calisthenics","Endurance Training");
        selectPlan.setValue("Full Body");
        middleContainer.add(choosePlan, selectPlan);


       Div formContainer = new Div();
       formContainer.setId("form-container");
       TextField titleField = new TextField("title");
       titleField.setId("title-field");
       TextField bpmField = new TextField("avg bpm");
       bpmField.setId("bpm-field");
       TextField timeSpendField = new TextField("time spend");
       timeSpendField.setId("time-spend-field");
       TextField dateField = new TextField("date");
       dateField.setId("date-field");
       formContainer.add(titleField, bpmField, timeSpendField, dateField);

       VerticalLayout exerciseContainer = new VerticalLayout();
       exerciseContainer.setId("exercise-container");
       H1 chooseExercise = new H1("choose exercise");
       chooseExercise.setClassName("choose-exercise-title");
       exerciseContainer.add(chooseExercise);
       List<Exercise> exerciseList = exerciseService.getAllExercises();
       for (Exercise exercise : exerciseList) {
           HorizontalLayout exerciseDiv = new HorizontalLayout();
           exerciseDiv.setClassName("exercise-div");
           H1 exerciseTitle = new H1(exercise.getName());
           exerciseTitle.setClassName("exercise-title");
           TextField reps = new TextField("reps");
           reps.setClassName("reps-field");
           TextField sets = new TextField("sets");
           sets.setClassName("sets-field");
           Checkbox addExercise = new Checkbox();
           exerciseDiv.add(exerciseTitle, reps, sets,addExercise);
           exerciseContainer.add(exerciseDiv);
       }
//       logWorkout.addClickListener(e -> {
//           Workout workout = new Workout();
//       });
       middleContainer.add(choosePlanContainer, formContainer, exerciseContainer);
       workoutDiv.add(leftContainer, topContainer, middleContainer);
       add(workoutDiv);
   }
}
