package com.example.oop2ipf24.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the confirmation-view.fxml file.
 */
public class ConfirmationController {

    @FXML
    private Label confirmationMessage;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    /**
     * Handles the "Buy Ticket" button click event.
     */
    @FXML
    private void onConfirm(ActionEvent event) {
        // Handle the "Back" button click - navigate to client-view (or any other view)
        navigateToClientView(event);
    }

    /**
     * Handles the "Cancel" button click event.
     */
    @FXML
    private void onCancel(ActionEvent event) {
        // Handle the "Close" button click - close the program
        closeApplication(event);
    }

    /**
     * Navigates to the client-view.fxml file.
     */
    private void navigateToClientView(ActionEvent event) {
        try {
            // Load the client-view.fxml and show it
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/client-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Client View");
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current window (confirmation dialog)
            closeWindow(event);

        } catch (IOException e) {
            e.printStackTrace();
            // Optionally show an alert for error handling
            showErrorAlert("Failed to load the Client View.");
        }
    }

    /**
     * Closes the current window.
     */
    private void closeWindow(ActionEvent event) {
        // Get the current stage (confirmation window) and close it
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Closes the entire application.
     */
    private void closeApplication(ActionEvent event) {
        // Close the entire application
        Platform.exit();
    }

    /**
     * Displays an error message in an alert dialog.
     *
     * @param message the error message to display
     */
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error occurred");
        alert.setContentText(message);
        alert.showAndWait();
    }
}


