package com.example.traininapp.Views;

import com.example.traininapp.UserPack.User;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.WorkoutPack.Workout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Route("register")
public class RegisterView extends VerticalLayout {
    private final UserService userService;

    @Autowired
    public RegisterView(UserService userService) {
        this.userService = userService;

        setClassName("register-view");

        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setClassName("register-form");

        H1 title = new H1("REGISTER");
        title.setClassName("register-title");

        TextField name = new TextField("name");
        TextField surname = new TextField("surname");
        EmailField email = new EmailField("email");
        PasswordField password = new PasswordField("password");

        name.setClassName("input-name");
        surname.setClassName("input-surname");
        email.setClassName("input-email");
        password.setClassName("input-password");

        HorizontalLayout userNameSurnameLayout = new HorizontalLayout(name, surname);
        userNameSurnameLayout.setWidth("100%");
        Text error = new Text("");
        Button registerButton = new Button("Register");
        registerButton.setClassName("register-button");
        registerButton.addClickListener(e -> {
            try {
                List<Workout> workoutList = new LinkedList<>();
                User newUser = new User(
                        workoutList,
                        password.getValue(),
                        email.getValue(),
                        surname.getValue(),
                        name.getValue());
                userService.addUser(newUser);
                UI.getCurrent().navigate("login");
               // System.out.println(userService.getAllUsers());
            }
            catch (Exception ex) {
                error.setText(ex.getMessage());
                throw new IllegalStateException(ex);
            }
        });

        formLayout.add(name, surname, email, password,error, registerButton);
        add(formLayout);
    }
}
