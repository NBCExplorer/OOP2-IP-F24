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
 * Controller for the Confirmation view.
 */
public class ConfirmationController {

    @FXML
    private Label confirmationMessage;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    /**
     * Sets the client's email address in the confirmation message.
     * @param email The client's email address.
     */
    public void setClientEmail(String email) {
        confirmationMessage.setText("Your e-ticket has been sent to " + email);
    }

    /**
     * Handles the confirm button click event.
     * @param event The event object.
     */
    @FXML
    private void onConfirm(ActionEvent event) {
        navigateToClientView(event);
    }

    /**
     * Handles the cancel button click event.
     * @param event The event object.
     */
    @FXML
    private void onCancel(ActionEvent event) {
        closeApplication(event);
    }

    /**
     * Navigates to the Client view.
     * @param event The event object.
     */
    private void navigateToClientView(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/client-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Client View");
            stage.setScene(new Scene(root));
            stage.show();

            closeWindow(event);

        } catch (IOException e) {
            e.printStackTrace();
            showErrorAlert("Failed to load the Client View.");
        }
    }

    /**
     * Closes the current window.
     * @param event The event object.
     */
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Closes the application.
     * @param event The event object.
     */
    private void closeApplication(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Shows an error alert with the given message.
     * @param message The message to display in the alert.
     */
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error occurred");
        alert.setContentText(message);
        alert.showAndWait();
    }
}

