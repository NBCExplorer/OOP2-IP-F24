package com.example.oop2ipf24.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editController {

    @FXML
    private TextField editMovieField;

    @FXML
    private Button saveEditMovieButton;

    private Runnable onSaveCallback; // Callback for the save action

    // Set a callback to be executed when the save button is clicked
    public void setOnSaveCallback(Runnable callback) {
        this.onSaveCallback = callback;
    }

    // Initialize the text field with the current movie title
    public void setMovie(String movie) {
        editMovieField.setText(movie);
    }

    // Save changes, execute callback, and close the window
    @FXML
    private void editSave(ActionEvent event) {
        // Execute the callback to perform any updates (if necessary)
        if (onSaveCallback != null) {
            onSaveCallback.run();
        }

        // Close the current stage (window)
        Stage stage = (Stage) saveEditMovieButton.getScene().getWindow();
        stage.close();
    }

    // Get the updated movie title from the TextField
    public String getUpdatedMovie() {
        return editMovieField.getText();
    }
}
