package com.example.traininapp.Views;

import com.example.traininapp.UserPack.User;
import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.Views.Components.ErrorNotification;
import com.example.traininapp.WorkoutPack.Workout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@CssImport("./styles/style.css")
@Route("/")
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

        TextField name = new TextField();
        name.setPlaceholder("Name");
        TextField surname = new TextField();
        surname.setPlaceholder("Surname");
        EmailField email = new EmailField();
        email.setPlaceholder("Email");
        PasswordField password = new PasswordField();
        password.setPlaceholder("Password");

        name.setClassName("input-name");
        surname.setClassName("input-surname");
        email.setClassName("input-email");
        password.setClassName("input-password");

        HorizontalLayout userNameSurnameLayout = new HorizontalLayout(name, surname);
        userNameSurnameLayout.setWidth("100%");
        Button registerButton = new Button("Register");
        Anchor anchor = new Anchor("login", "Already have an account?");
        anchor.setClassName("anchor-color");
        registerButton.setClassName("register-button");
        registerButton.addClickListener(e -> {
            if(Objects.equals(email.getValue(),"") || Objects.equals(password.getValue(),"") || Objects.equals(name.getValue(),"") || Objects.equals(surname.getValue(),"")){
                ErrorNotification errorNotification = new ErrorNotification("No empty fields are allowed!");
            }else {
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
                    VaadinSession session = VaadinSession.getCurrent();
                    session.setAttribute("email", null);
                } catch (Exception ex) {
                    ErrorNotification errorNotification = new ErrorNotification(ex.getMessage());
                }
            }
        });
        Image logo = new Image("images/logo.png", "Logo");


        formLayout.add(title,name, surname, email, password, registerButton,anchor, logo);
        add(formLayout);
    }
}
