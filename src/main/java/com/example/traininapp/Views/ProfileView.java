package com.example.traininapp.Views;


import com.example.traininapp.UserPack.User;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.WorkoutPack.Workout;
import com.example.traininapp.WorkoutPack.WorkoutService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

@Route("profile")
public class ProfileView extends Div {
    private UserService userService;
    private WorkoutService workoutService;

    @Autowired
    public ProfileView(UserService userService, WorkoutService workoutService) {
        this.userService = userService;
        this.workoutService = workoutService;

        VaadinSession session = VaadinSession.getCurrent();
        String sessionEmail = session.getAttribute("email").toString();
        User user = userService.findByEmail(sessionEmail).orElseThrow(() -> new IllegalStateException("User not found"));
        String userId = String.valueOf(user.getId());
        String username = user.getName();
        String userSurname = user.getSurname();


        setId("profile-view");
        Div profileDiv = new Div();
        profileDiv.setId("profile-div");

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
        H1 title = new H1("PROFILE");
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

        VerticalLayout centerContainer = new VerticalLayout();
        centerContainer.setId("center-container");
        HorizontalLayout firstContainerInCenter = new HorizontalLayout();
        firstContainerInCenter.setId("first-container");
        Image profileImage = new Image();
        profileImage.setClassName("profile-image");
        profileImage.setSrc("profile-image.png");
        VerticalLayout userInfo = new VerticalLayout();
        userInfo.setId("user-info");
        Paragraph userIdParagraph = new Paragraph("id:"+userId);
        userIdParagraph.setClassName("user-info-id");
        Paragraph usernameUserSurnameParagraph = new Paragraph(username + " " + userSurname);
        usernameUserSurnameParagraph.setClassName("user-info-name");
        Paragraph userEmailParagraph = new Paragraph(sessionEmail);
        userEmailParagraph.setClassName("user-info-email");
        userInfo.add(userIdParagraph,usernameUserSurnameParagraph,userEmailParagraph);
        firstContainerInCenter.add(profileImage,userInfo);

        VerticalLayout secondContainer = new VerticalLayout();
        secondContainer.setId("second-container");
        Paragraph secondContainerTitle = new Paragraph("Your recent workouts:");
        VerticalLayout secondContainerWorkouts = new VerticalLayout();
        for(Workout workout :user.getWorkouts()){
            HorizontalLayout workoutInfo = new HorizontalLayout();
            workoutInfo.setClassName("workout-info");
            Paragraph workoutDate = new Paragraph(String.valueOf(workout.getDate()));
            workoutDate.setClassName("workout-date");
            Paragraph  timeSpentHolder = new Paragraph("time-spent:");
            timeSpentHolder.setClassName("workout-time-spent-holder");
            Paragraph timeSpent = new Paragraph(String.valueOf(workout.getTimeSpent()));
            timeSpent.setClassName("workout-time-spent");
            Paragraph  burntCalHolder = new Paragraph("burnt-cals:");
            burntCalHolder.setClassName("workout-burnt-cal-holder");
            Paragraph burntCals = new Paragraph(String.valueOf(workout.getBurntKcal()));
            burntCals.setClassName("workout-burnt-cals");
            workoutInfo.add(workoutDate,timeSpentHolder,timeSpent,burntCalHolder,burntCals);
            secondContainerWorkouts.add(workoutInfo);
        }
        secondContainer.add(secondContainerTitle,secondContainerWorkouts);
        centerContainer.add(firstContainerInCenter,secondContainer);
        profileDiv.add(leftContainer,topContainer,centerContainer);
        add(profileDiv);
    }
}
