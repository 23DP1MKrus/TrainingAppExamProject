package com.example.traininapp.Views;

import com.example.traininapp.PlanPack.PlanService;
import com.example.traininapp.PlanPack.Plans;
import com.example.traininapp.Views.Components.LeftNavigation;
import com.example.traininapp.Views.Components.TopBar;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;
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

        setId("plans-div");

        LeftNavigation leftContainer = new LeftNavigation();

        VerticalLayout rightContainer = new VerticalLayout();
        rightContainer.setId("plans-right-container");

        TopBar topContainer = new TopBar("Log Workout");

        VerticalLayout middleContainer = new VerticalLayout();
        middleContainer.setId("middle-container-plans");


        VerticalLayout filtersContainer = new VerticalLayout();
        filtersContainer.setId("filters-container");

        H1 filterTitle = new H1("filter by:");
        filterTitle.setClassName("filterBy-title");

        Select<String> difficultyFilter = new Select<>();
        difficultyFilter.setClassName("difficulty-filter");
        difficultyFilter.setItems("Beginner", "Intermediate", "Advanced", "All");
        difficultyFilter.setValue("All");
        difficultyFilter.setPlaceholder("Difficulty");

        Select<String> daysFilter = new Select<>();
        daysFilter.setClassName("days-filter");
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

        rightContainer.add(topContainer,middleContainer);

        add(leftContainer, rightContainer);



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
            HorizontalLayout filterInPlan = new HorizontalLayout();
            filterInPlan.setId("filter-in-plan");
            HorizontalLayout planDiv = new HorizontalLayout();
            planDiv.setClassName("plan-div");

            H2 planName = new H2(plan.getName());
            planName.setClassName("plan-title");

            Paragraph difficulty = new Paragraph(plan.getDifficulty());
            difficulty.setClassName("difficulty");

            Paragraph days = new Paragraph(plan.getDaysCount() + " days");
            days.setClassName("days");

            filterInPlan.add(difficulty, days);

            planDiv.add(planName, filterInPlan);
            plansContainer.add(planDiv);
        }
    }
}



