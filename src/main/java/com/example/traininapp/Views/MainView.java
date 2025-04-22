package com.example.traininapp.Views;

import com.example.traininapp.ChallengePack.Challenge;
import com.example.traininapp.ChallengePack.ChallengeService;
import com.example.traininapp.DoneExPack.DoneExercise;
import com.example.traininapp.UserPack.User;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.WorkoutPack.Workout;
import com.example.traininapp.WorkoutPack.WorkoutService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Route("main")
public class MainView extends Div {
    private WorkoutService workoutService;
    private ChallengeService challengeService;
    private UserService userService;

    @Autowired
    public MainView(UserService userService,WorkoutService workoutService, ChallengeService challengeService) {
        this.userService = userService;
        this.workoutService = workoutService;
        this.challengeService = challengeService;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        VaadinSession session = VaadinSession.getCurrent();
        String sessionEmail = session.getAttribute("email").toString();
        User user = userService.findByEmail(sessionEmail).orElseThrow(() -> new IllegalStateException("User not found"));
        List<Workout> workouts = (!user.getWorkouts().isEmpty()) ? user.getWorkouts() : null;
        Workout lastWorkout;
        String lastWorkoutName;
        String workoutDate;
        String workoutTimeSpent;
        String workoutBurntKcal;
        int sets = 0;
        int exCount = 0;
        if (workouts != null) {
            lastWorkout = workouts.get(workouts.size() - 1);
            lastWorkoutName = lastWorkout.getName();
            workoutDate = (String.valueOf(lastWorkout.getDate()));
            workoutTimeSpent = (timeFormatter.format(lastWorkout.getTimeSpent()));
            workoutBurntKcal = (String.valueOf(lastWorkout.getBurntKcal()));

            List<DoneExercise> lastWorkoutDoneExercises = lastWorkout.getDoneExercises();
            for (DoneExercise doneExercise : lastWorkoutDoneExercises) {
                exCount++;
                sets += doneExercise.getSets();
            }
        }
        else {
            lastWorkout = null;
            lastWorkoutName = "No Workout";
            workoutDate = "0000-00-00";
            workoutTimeSpent = "00:00";
            workoutBurntKcal = "0";
        }



        setId("main");

        Div mainContainer = new Div();
        mainContainer.setId("main-container");

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

        HorizontalLayout centerContainerUpperPart = new HorizontalLayout();
        centerContainerUpperPart.setId("center-upper-part");

        VerticalLayout centerContainerLowerPart = new VerticalLayout();
        centerContainerLowerPart.setId("center-lower-part");

        HorizontalLayout firstContainerInCenter = new HorizontalLayout();
        firstContainerInCenter.setId("first-container");

        VerticalLayout challengeContainer = new VerticalLayout();
        challengeContainer.setId("challenge-container");
        HorizontalLayout challengeContainerTitle = new HorizontalLayout();
        challengeContainerTitle.setId("challenge-container-title");
        Image challengeIcon = new Image();
        H1 challengeTitle = new H1("DAILY CHALLENGES");
        challengeContainerTitle.add(challengeIcon,challengeTitle);
        VerticalLayout challenges = new VerticalLayout();
        challenges.setId("challenges");

        List<Challenge> randomChallenges = new ArrayList<Challenge>();
        while (randomChallenges.size() < 5) {
            Challenge randomChallenge = challengeService.getRandomChallenge().orElseThrow(() -> new RuntimeException("random challenge not found"));
            if (!randomChallenges.contains(randomChallenge)) {
                randomChallenges.add(randomChallenge);
            }

        }


        for (Challenge challenge : randomChallenges) {
            Paragraph paragraph = new Paragraph();
            paragraph.setClassName("ChallengeParagraph");
            paragraph.setText(challenge.getContent());
            challenges.add(paragraph);
        }

        challengeContainer.add(challengeContainerTitle, challenges);
        firstContainerInCenter.add(challengeContainer);

        VerticalLayout secondContainer = new VerticalLayout();
        secondContainer.setId("second-container");

        HorizontalLayout secondContainerUpper = new HorizontalLayout();
        HorizontalLayout secondContainerLower = new HorizontalLayout();

        VerticalLayout burntCalWidget = new VerticalLayout();
        burntCalWidget.setClassName("main-container-widget");
        HorizontalLayout burntCalWidgetTitle = new HorizontalLayout();
        burntCalWidgetTitle.setClassName("main-container-widget-title");
        Image burntCalIcon = new Image();
        H1 burntCalTitle = new H1("CALORIES BURNT");
        burntCalWidgetTitle.add(burntCalIcon,burntCalTitle);
        Paragraph burntCals= new Paragraph();
        burntCals.setClassName("widget-context");
        burntCals.setText(workoutBurntKcal); //current user burnt cals
        burntCalWidget.add(burntCalWidgetTitle,burntCals);

        VerticalLayout workTimeWidget = new VerticalLayout();
        workTimeWidget.setClassName("main-container-widget");
        HorizontalLayout workTimeWidgetTitle = new HorizontalLayout();
        workTimeWidgetTitle.setClassName("main-container-widget-title");
        Image workTimeImage = new Image();
        H1 workTimeTitle = new H1("WORKOUT TIME");
        workTimeWidgetTitle.add(workTimeImage,workTimeTitle);
        Paragraph workoutTime = new Paragraph();
        workoutTime.setClassName("widget-context");
        workoutTime.setText(workoutTimeSpent); //current user workout time
        workTimeWidget.add(workTimeWidgetTitle,workoutTime);

        VerticalLayout setsCountWidget = new VerticalLayout();
        setsCountWidget.setClassName("main-container-widget");
        HorizontalLayout setsCountWidgetTitle = new HorizontalLayout();
        setsCountWidgetTitle.setClassName("main-container-widget-title");
        Image setsCountWidgetImage = new Image();
        H1 setsCountTitle = new H1("SETS COUNT");
        setsCountWidgetTitle.add(setsCountWidgetImage,setsCountTitle);
        Paragraph setsCount= new Paragraph();
        setsCount.setClassName("widget-context");
        setsCount.setText(String.valueOf(sets)); //current user burnt cals
        setsCountWidget.add(setsCountWidgetTitle,setsCount);

        VerticalLayout exCountWidget = new VerticalLayout();
        exCountWidget.setClassName("main-container-widget");
        HorizontalLayout exCountWidgetTitle = new HorizontalLayout();
        exCountWidgetTitle.setClassName("main-container-widget-title");
        Image exCountWidgetImage = new Image();
        H1 exCountTitle = new H1("EXERCISE COUNT");
        exCountWidgetTitle.add(exCountWidgetImage,exCountTitle);
        Paragraph exsCount = new Paragraph();
        exsCount.setClassName("widget-context");
        exsCount.setText(String.valueOf(exCount)); //current user workout time
        exCountWidget.add(exCountWidgetTitle,exsCount);


        VerticalLayout thirdContainer = new VerticalLayout();
        thirdContainer.setId("third-container");
        Paragraph thirdContainerTitle = new Paragraph();
        thirdContainerTitle.setId("third-container-title");
        thirdContainerTitle.setText("Last Workout");
        Span divider = new Span();
        divider.setId("divider");
        HorizontalLayout lastWorkoutContainer = new HorizontalLayout();
        lastWorkoutContainer.setId("last-workout");
        Paragraph lastWorkoutTitle = new Paragraph();
        lastWorkoutTitle.setId("last-workout-title");
        lastWorkoutTitle.setText(lastWorkoutName);
        Paragraph lastWorkoutDate = new Paragraph();
        lastWorkoutDate.setId("last-workout-date");
        lastWorkoutDate.setText(workoutDate);
        lastWorkoutContainer.add(lastWorkoutTitle,lastWorkoutDate);
        thirdContainer.add(thirdContainerTitle,divider,lastWorkoutContainer);

        secondContainerUpper.add(burntCalWidget,workTimeWidget);
        secondContainerLower.add(setsCountWidget,exCountWidget);

        secondContainer.add(secondContainerUpper,secondContainerLower);

        centerContainerUpperPart.add(secondContainer,firstContainerInCenter);
        centerContainerLowerPart.add(thirdContainer);

        centerContainer.add(centerContainerUpperPart,centerContainerLowerPart);

        mainContainer.add(leftContainer,topContainer,centerContainer);
        add(mainContainer);

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
