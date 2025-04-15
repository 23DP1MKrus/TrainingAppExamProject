package com.example.traininapp.Views;


import com.example.traininapp.DoneExPack.DoneExService;
import com.example.traininapp.DoneExPack.DoneExercise;
import com.example.traininapp.ExercisePack.Exercise;
import com.example.traininapp.ExercisePack.ExerciseService;
import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.WorkoutPack.Workout;
import com.example.traininapp.WorkoutPack.WorkoutService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Route("logWorkout")
public class LogWorkoutView extends Div {
   private final WorkoutService workoutService;
   private final ExerciseService exerciseService;
   private final DoneExService doneExService;
   private final UserService userService;
   private final PlanService planService;

   @Autowired
    public LogWorkoutView(WorkoutService workoutService, ExerciseService exerciseService, DoneExService doneExService,  UserService userService,  PlanService planService) {
       this.workoutService = workoutService;
       this.exerciseService = exerciseService;
       this.doneExService = doneExService;
       this.userService = userService;
       this.planService = planService;
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
       TextField dateField = new TextField("date(2025-04-09)");
       dateField.setId("date-field");
       formContainer.add(titleField, bpmField, timeSpendField, dateField);

       VerticalLayout exerciseContainer = new VerticalLayout();
       exerciseContainer.setId("exercise-container");
       H1 chooseExercise = new H1("choose exercise");
       chooseExercise.setClassName("choose-exercise-title");
       exerciseContainer.add(chooseExercise);
       List<Exercise> exerciseList = exerciseService.getAllExercises();
       List<Checkbox> checkboxList = new ArrayList<>();
       for (Exercise exercise : exerciseList) {
           HorizontalLayout exerciseDiv = new HorizontalLayout();
           exerciseDiv.setClassName("exercise-div");
           H1 exerciseTitle = new H1(exercise.getName());
           exerciseTitle.setClassName("exercise-title");
           TextField weight = new TextField("weight");
           weight.setClassName("weight-field");
           TextField reps = new TextField("reps");
           reps.setClassName("reps-field");
           TextField sets = new TextField("sets");
           sets.setClassName("sets-field");
           Checkbox addExercise = new Checkbox();
           addExercise.setId(String.valueOf(exercise.getId()));
           checkboxList.add(addExercise);
           exerciseDiv.add(exerciseTitle, weight, reps, sets,addExercise);
           exerciseContainer.add(exerciseDiv);
       }

       logWorkout.addClickListener(e -> {
           VaadinSession session = VaadinSession.getCurrent();
           String sessionEmail = session.getAttribute("email").toString();
           DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
           List<DoneExercise> addedDoneExList = new ArrayList<>();
            for (Component component : exerciseContainer.getChildren().toList()) {
                List<Component> innerExComponentsList = component.getChildren().toList();
                if (!innerExComponentsList.isEmpty()) {
                    Checkbox innerDoneExCheckbox = ((Checkbox) innerExComponentsList.get(4));
                    if ((innerDoneExCheckbox.getValue().equals(true))) {
                        DoneExercise doneExercise = new DoneExercise();
                        doneExercise.setWeight(Integer.parseInt(((TextField) innerExComponentsList.get(1)).getValue()));
                        doneExercise.setSets(Integer.parseInt(((TextField) innerExComponentsList.get(3)).getValue()));
                        doneExercise.setReps(Integer.parseInt(((TextField) innerExComponentsList.get(2)).getValue()));
                        doneExercise.setExercise(exerciseList.get(indexOf(component)+1));
                        addedDoneExList.add(doneExercise);

                    }
                }
            }


           Workout workout = new Workout(
                   userService.findByEmail(sessionEmail).orElseThrow(()->new IllegalArgumentException("User not found")),
                   addedDoneExList,
                   123.1f,
                   Integer.valueOf(bpmField.getValue()),
                   LocalDate.parse(dateField.getValue(), dateFormatter),
                   LocalTime.parse(timeSpendField.getValue(),timeFormatter),
                   titleField.getValue(),
                   planService.findByName(selectPlan.getValue())
                   );
            workoutService.addWorkout(workout);
            for(DoneExercise doneExercise : addedDoneExList){
                doneExercise.setWorkout(workout);
                doneExService.addDoneExercise(doneExercise);
            }
            userService.findByEmail(sessionEmail).orElseThrow(()->new IllegalArgumentException("User not found")).getWorkouts().add(workout);
       });
       middleContainer.add(choosePlanContainer, formContainer, exerciseContainer);
       workoutDiv.add(leftContainer, topContainer, middleContainer);
       add(workoutDiv);
   }
}
