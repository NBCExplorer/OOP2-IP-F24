package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Client;
import com.example.oop2ipf24.Model.Manager;
import com.example.oop2ipf24.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private Button closeButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    // Event handler for the "Log in" button
    private final List<User> users = new ArrayList<>();

    public LoginController() {
        // Add manager and client to the user list
        users.add(new Manager("manager1", "password1"));
        users.add(new Client("client1", "password2"));
    }

    private void onLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User authenticatedUser = authenticateUser(username, password);

        if (authenticatedUser != null) {
            if (authenticatedUser instanceof Manager) {
                navigateTo("manager.fxml", "Manager Dashboard");
            } else if (authenticatedUser instanceof Client) {
                navigateTo("client-view.fxml", "Client Dashboard");
            }
        } else {
            showAlert("Error", "Invalid username or password.");
        }
    }

    private void navigateTo(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

            ((Stage) loginButton.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load the requested view: " + fxmlFile);
        }
    }

    private User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private void showAlert(String error, String s) {
    }

    // Event handler for the "Sign up" button
    @FXML
    private void onSignUp(ActionEvent event) {
        showAlert("Info", "Sign-Up functionality not yet implemented.");
    }
    
}
