package com.example.traininapp.Views;

import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.PlanPack.Plans;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("plans")
public class PlansView extends Div {
    private final PlanService planService;

    @Autowired
    public PlansView(PlanService planService) {
        this.planService = planService;
        setId("plans-view");

        Div plansDiv = new Div();
        plansDiv.setId("plans-div");

        VerticalLayout leftContainer = new VerticalLayout();
        leftContainer.setId("left-container");

        Image logo = new Image();
        logo.setClassName("logo");

        leftContainer.add(
                createNavLink("PLANS", "plans"),
                createNavLink("Exercises", "exercises"),
                createNavLink("MAIN", "main"),
                createNavLink("WORKOUTS", "workouts")
        );

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

        VerticalLayout filtersContainer = new VerticalLayout();
        filtersContainer.setId("filters-container");

        H1 filterTitle = new H1("filter by:");
        filterTitle.setClassName("filterBy-title");

        Select<String> difficultyFilter = new Select<>();
        difficultyFilter.setItems("Beginner", "Intermediate", "Advanced");
        difficultyFilter.setPlaceholder("Difficulty");

        Select<String> daysFilter = new Select<>();
        daysFilter.setItems("3 days", "4 days", "5 days");
        daysFilter.setPlaceholder("Days");

        filtersContainer.add(filterTitle, difficultyFilter, daysFilter);

        VerticalLayout plansContainer = new VerticalLayout();
        plansContainer.setId("plans-container");

        H1 foundPlans = new H1("FOUND PLANS FOR YOU");
        foundPlans.setClassName("found-plans-title");

        plansContainer.add(foundPlans);

        List<Plans> plansList = planService.getAllPlans();
        for (Plans plan : plansList) {
            HorizontalLayout planDiv = new HorizontalLayout();
            planDiv.setClassName("plan-div");

            H2 planName = new H2(plan.getName());
            planName.setClassName("plan-title");

            Paragraph difficulty = new Paragraph(plan.getDifficulty());
            difficulty.setClassName("difficulty");

            Paragraph days = new Paragraph(plan.getDaysCount() + " days");
            days.setClassName("days");

            planDiv.add(planName, difficulty, days);
            plansContainer.add(planDiv);
        }

        middleContainer.add(filtersContainer, plansContainer);

        plansDiv.add(leftContainer, topContainer, middleContainer);
        add(plansDiv);
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

