package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Client;
import com.example.oop2ipf24.Model.Manager;
import com.example.oop2ipf24.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    // List of users (Manager and Client) for login validation
    private final List<User> users = new ArrayList<>();

    public LoginController() {
        // Adding sample Manager and Client users
        users.add(new Manager("manager1", "password1"));
        users.add(new Client("client1", "password2"));
    }

    /**
     * Handles the login button click event.
     */
    @FXML
    private void onLogin(ActionEvent event) {
        // Retrieve input credentials
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Authenticate user
        User authenticatedUser = authenticateUser(username, password);

        if (authenticatedUser != null) {
            // Navigate to the correct view based on user type
            if (authenticatedUser instanceof Manager) {
                navigateTo("/com/example/oop2ipf24/manager.fxml", "Manager Dashboard", event);
            } else if (authenticatedUser instanceof Client) {
                navigateTo("/com/example/oop2ipf24/client-view.fxml", "Client Dashboard", event);
            }
        } else {
            // Show an error message for invalid credentials
            showError("Invalid login credentials! Please try again.");
        }
    }

    /**
     * Authenticates the user based on username and password.
     *
     * @param username the entered username
     * @param password the entered password
     * @return the authenticated User object or null if authentication fails
     */
    private User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // Authentication failed
    }

    /**
     * Navigates to a specific view.
     *
     * @param fxmlFile the FXML file path
     * @param title    the title for the new stage
     * @param event    the triggering ActionEvent
     */
    private void navigateTo(String fxmlFile, String title, ActionEvent event) {
        try {
            // Debugging: Print the file path
            System.out.println(getClass().getResource(fxmlFile));

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show(); // Ensure the stage is shown
        } catch (IOException e) {
            e.printStackTrace();
            showError("Failed to load the requested view: " + fxmlFile);
        }
    }


    /**
     * Displays an error message in an alert dialog.
     *
     * @param message the error message to display
     */
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Placeholder for the "Sign Up" button functionality.
     */
    @FXML
    private void onSignUp(ActionEvent event) {
        navigateTo("/com/example/oop2ipf24/signup-view.fxml", "Sign Up", event);
    }


    @FXML
    private void onClose(ActionEvent event) {
        // Close the current window
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}


