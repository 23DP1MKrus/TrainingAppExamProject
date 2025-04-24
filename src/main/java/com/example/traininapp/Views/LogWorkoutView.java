package com.example.traininapp.Views;


import com.example.traininapp.DoneExPack.DoneExService;
import com.example.traininapp.DoneExPack.DoneExercise;
import com.example.traininapp.ExercisePack.Exercise;
import com.example.traininapp.ExercisePack.ExerciseService;
import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.Views.Components.ErrorNotification;
import com.example.traininapp.Views.Components.LeftNavigation;
import com.example.traininapp.Views.Components.TopBar;
import com.example.traininapp.WorkoutPack.Workout;
import com.example.traininapp.WorkoutPack.WorkoutService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
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
import java.util.Objects;

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

       LeftNavigation leftContainer = new LeftNavigation();

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
           String valueBpm = bpmField.getValue();
           String valueDate = dateField.getValue();
           String timeSpendFieldValue = timeSpendField.getValue();
           String valueTitle = titleField.getValue();
           String valuePlan = selectPlan.getValue();

            for (Component component : exerciseContainer.getChildren().toList()) {
                List<Component> innerExComponentsList = component.getChildren().toList();
                if (!innerExComponentsList.isEmpty()) {
                    Checkbox innerDoneExCheckbox = ((Checkbox) innerExComponentsList.get(4));
                    try{
                            if ((innerDoneExCheckbox.getValue().equals(true))) {
                                String weightValue = ((TextField) innerExComponentsList.get(1)).getValue();
                                String setsValue = ((TextField) innerExComponentsList.get(3)).getValue();
                                String repsValue = ((TextField) innerExComponentsList.get(2)).getValue();
                                DoneExercise doneExercise = new DoneExercise();
                                doneExercise.setWeight(Integer.parseInt(weightValue));
                                doneExercise.setSets(Integer.parseInt(setsValue));
                                doneExercise.setReps(Integer.parseInt(repsValue));
                                doneExercise.setExercise(exerciseList.get(indexOf(component)+1));
                                addedDoneExList.add(doneExercise);
                            }

                        } catch (Exception ex) {
                        ErrorNotification errorNotification = new ErrorNotification("Please enter all fields in exercise!");
                        }

                    }
                }
           if (addedDoneExList.isEmpty()) {
               ErrorNotification errorNotification = new ErrorNotification("Please add at least one exercise to your exercise list!");
           }else {

               try{
                   Workout workout = new Workout(
                           userService.findByEmail(sessionEmail).orElseThrow(()->new IllegalArgumentException("User not found")),
                           addedDoneExList,
                           Integer.parseInt(valueBpm) * 4f,
                           Integer.valueOf(valueBpm),
                           LocalDate.parse(valueDate, dateFormatter),
                           LocalTime.parse(timeSpendFieldValue,timeFormatter),
                           valueTitle,
                           planService.findByName(valuePlan)
                   );
                   workoutService.addWorkout(workout);
                   for(DoneExercise doneEx: addedDoneExList){
                       doneEx.setWorkout(workout);
                       doneExService.addDoneExercise(doneEx);
                   }
                   userService.findByEmail(sessionEmail).orElseThrow(()->new IllegalArgumentException("User not found")).getWorkouts().add(workout);
                   Notification notification = Notification
                           .show("Workout added");
                   notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);

               }
               catch (Exception ex) {
                   ErrorNotification errorNotification = new ErrorNotification("Please enter all fields in workout!");
               }
           }



       });
       middleContainer.add(choosePlanContainer, formContainer, exerciseContainer);
       workoutDiv.add(leftContainer, topContainer, middleContainer);
       add(workoutDiv);
   }
}
