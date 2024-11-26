package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent; // Correct import for JavaFX ActionEvent
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    // Declare the necessary fields for the input fields
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button signupButton;
    @FXML
    private Button backButton;

    @FXML
    private void onSignup(ActionEvent event) {
        // Get the input values
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Check if all fields are filled out
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showErrorAlert("All fields must be filled out.");
            return;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            showErrorAlert("Passwords do not match.");
            return;
        }

        // Add the new client to the static users map in LoginController
        LoginController.users.put(username, new Client(username, password));  // Add new client

        // Show success message
        showInfoAlert("Sign up successful!");

        // Navigate to login page
        navigateTo("/com/example/oop2ipf24/login-view.fxml", "Login", event);
    }

    // Show error alert
    private void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Signup Failed");
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Show info alert
    private void showInfoAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Signup Successful");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onBackToLogin(ActionEvent event) {
        navigateTo("/com/example/oop2ipf24/login-view.fxml", "Login", event);
    }

    // Navigate to another view
    private void navigateTo(String fxmlFilePath, String title, ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePath));
            Parent root = loader.load();

            // Get the current stage (window) and switch the scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading the FXML file: " + fxmlFilePath);
        }
    }
}


