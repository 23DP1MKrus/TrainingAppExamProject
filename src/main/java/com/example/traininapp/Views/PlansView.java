package com.example.traininapp.Views;

import ch.qos.logback.core.util.COWArrayList;
import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.PlanPack.Plans;
import com.example.traininapp.Views.Components.LeftNavigation;
import com.example.traininapp.Views.Components.TopBar;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("plans")
public class PlansView extends Div {
    private final PlanService planService;
    private final VerticalLayout plansContainer;

    @Autowired
    public PlansView(PlanService planService) {
        this.planService = planService;
        this.plansContainer = new VerticalLayout();

        setId("plans-view");

        Div plansDiv = new Div();
        plansDiv.setId("plans-div");

        LeftNavigation leftContainer = new LeftNavigation();

        TopBar topContainer = new TopBar("Log Workout");

        VerticalLayout middleContainer = new VerticalLayout();
        middleContainer.setId("middle-container");


        VerticalLayout filtersContainer = new VerticalLayout();
        filtersContainer.setId("filters-container");

        H1 filterTitle = new H1("filter by:");
        filterTitle.setClassName("filterBy-title");

        Select<String> difficultyFilter = new Select<>();
        difficultyFilter.setItems("Beginner", "Intermediate", "Advanced", "All");
        difficultyFilter.setValue("All");
        difficultyFilter.setPlaceholder("Difficulty");

        Select<String> daysFilter = new Select<>();
        daysFilter.setItems("3", "4", "5", "All");
        daysFilter.setValue("All");
        daysFilter.setPlaceholder("Days count");

        filtersContainer.add(filterTitle, difficultyFilter, daysFilter);


        difficultyFilter.addValueChangeListener(event -> {
            applyFilters(difficultyFilter.getValue(), daysFilter.getValue());
        });

        daysFilter.addValueChangeListener(event -> {
            applyFilters(difficultyFilter.getValue(), daysFilter.getValue());
        });

        filtersContainer.add(filterTitle, difficultyFilter, daysFilter);


        plansContainer.setId("plans-container");


        showPlans(planService.getAllPlans());

        middleContainer.add(filtersContainer, plansContainer);

        plansDiv.add(leftContainer, topContainer, middleContainer);

        add(plansDiv);

        plansContainer.setId("plans-container");

        showPlans(planService.getAllPlans());

        middleContainer.add(filtersContainer, plansContainer);

        plansDiv.add(leftContainer, topContainer, middleContainer);

        add(plansDiv);

    }


    private HorizontalLayout createNavLink(String text, String route) {
        Anchor anchor = new Anchor(route, text);
        anchor.setClassName("nav-link");
        HorizontalLayout navLayout = new HorizontalLayout();
        navLayout.add(anchor);
        return navLayout;
    }

    private void applyFilters(String difficultyFilter, String daysFilter) {

        List<Plans> allPlans = planService.getAllPlans();

        List<Plans> filteredPlans = new ArrayList<>();

        for (Plans plan : allPlans) {
            boolean matchDiff = difficultyFilter.equals("All") || plan.getDifficulty().equals(difficultyFilter);
            boolean matchDays = daysFilter.equals("All") || plan.getDaysCount() == Integer.parseInt(daysFilter);

            if (matchDiff && matchDays) {
                filteredPlans.add(plan);
            }
        }

        showPlans(filteredPlans);




    }

    private void showPlans(List<Plans> plans) {

        plansContainer.removeAll();

        H1 foundPlans = new H1("PLANS FOUND 4 YOU");
        foundPlans.setClassName("found-plans-title");
        plansContainer.add(foundPlans);

        if (plans.isEmpty()) {
            Paragraph noPlans = new Paragraph("No plans 4 you :( ");
            noPlans.setClassName("no-plans");
            plansContainer.add(noPlans);
        }

        for (Plans plan : plans) {
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
    }
}



