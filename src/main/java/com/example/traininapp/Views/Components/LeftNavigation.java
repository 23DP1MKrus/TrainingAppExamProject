package com.example.traininapp.Views.Components;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LeftNavigation extends VerticalLayout {
    public LeftNavigation() {
        setId("left-navigation");
        Image logo = new Image();
        logo.setClassName("logo");
        add(
                logo,
                new Anchor("plans","PLANS"),
                new Anchor("main","MAIN"),
                new Anchor("workouts","WORKOUTS"),
                new Anchor("exercises","EXERCISES")
        );
    }
}
