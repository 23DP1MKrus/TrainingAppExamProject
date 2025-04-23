package com.example.traininapp.Views;

import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.UserPack.User;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.Views.Components.LeftNavigation;
import com.example.traininapp.Views.Components.TopBar;
import com.example.traininapp.WorkoutPack.Workout;
import com.example.traininapp.WorkoutPack.WorkoutService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

@Route("workouts")
public class WorkoutsView extends Div{
    private UserService userService;
    private WorkoutService workoutService;

    @Autowired
    public WorkoutsView(UserService userService, WorkoutService workoutService) {
        this.userService = userService;
        this.workoutService = workoutService;


        VaadinSession session = VaadinSession.getCurrent();
        String sessionEmail = session.getAttribute("email").toString();
        User user = userService.findByEmail(sessionEmail).orElseThrow(() -> new IllegalStateException("User not found"));

        Div workoutsDiv = new Div();
        workoutsDiv.setId("workouts-div");

        LeftNavigation leftContainer = new LeftNavigation();

        TopBar topContainer = new TopBar("Log Workout");

        VerticalLayout workoutsContainer = new VerticalLayout();
        workoutsContainer.setId("workouts-container");

        if (user.getWorkouts().isEmpty()) {
            Paragraph noWorkouts = new Paragraph("Click 'log workout' to add your first workout.");
            workoutsContainer.add(noWorkouts);
        } else {
            for (Workout workout : user.getWorkouts()) {
                HorizontalLayout workoutsField = new HorizontalLayout();
                workoutsField.setClassName("workout-field");
                Paragraph workoutDate = new Paragraph(String.valueOf(workout.getDate()));
                workoutDate.setClassName("workout-date");
                Paragraph timeSpentHolder = new Paragraph("time-spent:");
                timeSpentHolder.setClassName("workout-time-spent-holder");
                Paragraph timeSpent = new Paragraph(String.valueOf(workout.getTimeSpent()));
                timeSpent.setClassName("workout-time-spent");
                Paragraph burntCalHolder = new Paragraph("burnt-cals:");
                burntCalHolder.setClassName("workout-burnt-cal-holder");
                Paragraph burntCals = new Paragraph(String.valueOf(workout.getBurntKcal()));
                burntCals.setClassName("workout-burnt-cals");
                workoutsField.add(workoutDate, timeSpentHolder, timeSpent, burntCalHolder, burntCals);
                workoutsContainer.add(workoutsField);
            }
        }

        workoutsDiv.add(leftContainer, topContainer, workoutsContainer);
        add(workoutsDiv);
    }


    private HorizontalLayout createNavLink(String text, String route) {
        Paragraph anchorText = new Paragraph(text);
        Anchor anchor = new Anchor(route, "");
        anchor.setClassName("nav-link");
        anchorText.setClassName("nav-link-text");
        anchorText.add(anchor);
        HorizontalLayout navLayout = new HorizontalLayout();
        navLayout.add(anchorText);
        return navLayout;
    }




    }
