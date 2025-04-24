package com.example.traininapp.Views;

import com.example.traininapp.UserPack.UserService;
import com.example.traininapp.Views.Components.ErrorNotification;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


@Route("login")
public class LoginView extends VerticalLayout {
    private final UserService userService;

    @Autowired
    public LoginView(UserService userService) {
        this.userService = userService;

        setClassName("login-view");

        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setClassName("login-form");

        H1 title = new H1("LOGIN");
        title.setClassName("login-title");

        EmailField email = new EmailField("email");
        PasswordField password = new PasswordField("password");

        email.setClassName("input-email");
        password.setClassName("input-password");

        Text error = new Text("");
        Button loginButton = new Button("Log in");
        Anchor anchor = new Anchor("register", "Don't have an account yet?");
        loginButton.setClassName("login-button");
        loginButton.addClickListener(e -> {
            if(Objects.equals(email.getValue(),"") || Objects.equals(password.getValue(),"")){
                ErrorNotification errorNotification = new ErrorNotification("Empty fields are not allowed!");
            } else {
                if (userService.canLogin(email.getValue(), password.getValue())) {
                    VaadinSession session = VaadinSession.getCurrent();
                    session.setAttribute("email", email.getValue());
                    UI.getCurrent().navigate("main");
                } else {
                    error.setText("login-error");
                }
            }
        });

        formLayout.add(email, password,error, loginButton,anchor);
        add(formLayout);
    }
    }



