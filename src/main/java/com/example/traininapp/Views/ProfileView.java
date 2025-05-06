package com.example.traininapp.Views;


import com.example.traininapp.UserPack.User;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.Views.Components.LeftNavigation;
import com.example.traininapp.Views.Components.TopBar;
import com.example.traininapp.WorkoutPack.Workout;
import com.example.traininapp.WorkoutPack.WorkoutService;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport("./styles/style.css")
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


        setId("profile-div");

        LeftNavigation leftContainer = new LeftNavigation();

        VerticalLayout rightContainer = new VerticalLayout();
        rightContainer.setId("profile-right-container");

        TopBar topContainer = new TopBar("your profile");

        VerticalLayout centerContainer = new VerticalLayout();
        centerContainer.setId("center-container-profile");
        HorizontalLayout firstContainerInCenter = new HorizontalLayout();
        firstContainerInCenter.setId("first-container");
        Image profileImage = new Image();
        profileImage.setId("profile-pic");
        profileImage.setSrc("images/profilePic.png");
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
        secondContainer.setId("second-container-profile");
        Paragraph secondContainerTitle = new Paragraph("Your recent workouts:");
        secondContainerTitle.setClassName("second-container-title");
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
        rightContainer.add(topContainer,centerContainer);

//        HorizontalLayout layoutWrapper = new HorizontalLayout();
//        layoutWrapper.setId("layout-wrapper");
//        layoutWrapper.setSizeFull();
//        layoutWrapper.setSpacing(false);
//        layoutWrapper.setPadding(false);
//
//        VerticalLayout rightSection = new VerticalLayout();
//        rightSection.setId("right-section");
//        rightSection.setSpacing(false);
//        rightSection.setPadding(false);
//        rightSection.setSizeFull();
//
//        rightSection.add(topContainer, centerContainer);
//        layoutWrapper.add(leftContainer, rightSection);

        add(leftContainer, rightContainer);



    }
}
