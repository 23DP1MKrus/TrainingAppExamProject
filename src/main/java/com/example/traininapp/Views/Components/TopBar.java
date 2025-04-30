package com.example.traininapp.Views.Components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class TopBar extends HorizontalLayout {
    public TopBar(String titleText) {
        setId("top-bar");
        H1 title = new H1(titleText);
        title.setClassName("title");

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setId("buttons");
        Button logWorkout = new Button("log workout");
        logWorkout.setClassName("log-workout-button");
        Image searchIcon = new Image("images/search.png", "Search");
        Button searchBtn = new Button(searchIcon);
        searchBtn.setClassName("topBtn");
        Image ringIcon = new Image("images/bell.png", "Ring");
        Button ringBtn = new Button(ringIcon);
        ringBtn.setClassName("topBtn");
        Image profileIcon = new Image("images/person.png", "Profile");
        Button profileBtn = new Button(profileIcon);
        profileBtn.setClassName("topBtn");

        buttons.add(logWorkout, searchBtn, ringBtn, profileBtn);
        logWorkout.addClickListener(e -> {
            UI.getCurrent().navigate("logWorkout");
        });
        add(title,buttons);
    }
}
