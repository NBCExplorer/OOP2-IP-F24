package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent; // Correct import for JavaFX ActionEvent

import java.io.IOException;

public class SignupController {

    @FXML
    private void onBackToLogin(ActionEvent event) {
        navigateTo("/com/example/oop2ipf24/login-view.fxml", "Login", event);
    }

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

