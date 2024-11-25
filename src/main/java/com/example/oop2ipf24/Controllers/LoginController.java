package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;

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
    @FXML
    private void onLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Mock authentication logic
        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please fill in both fields.");
        } else if (username.equals("admin") && password.equals("password")) {
            showAlert("Success", "Login successful!");
            // Navigate to manager or client dashboard here
        } else {
            showAlert("Error", "Invalid username or password.");
        }
    }

    private void showAlert(String error, String s) {
    }

    // Event handler for the "Sign up" button
    @FXML
    private void onSignUp(ActionEvent event) {
        showAlert("Info", "Sign-Up functionality not yet implemented.");
    }
    
}
