package com.example.oop2ipf24.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editRoomController {

    @FXML
    private TextField editRoomField;

    @FXML
    private Button saveEditRoomButton;

    private Runnable onSaveCallback; // Callback for the save action

    // Set a callback to be executed when the save button is clicked
    public void setOnSaveCallback(Runnable callback) {
        this.onSaveCallback = callback;
    }

    // Initialize the text field with the current room name
    public void setRoom(String room) {
        editRoomField.setText(room);
    }

    // Save changes, execute callback, and close the window
    @FXML
    private void editSave(ActionEvent event) {
        // Execute the callback to perform any updates (if necessary)
        if (onSaveCallback != null) {
            onSaveCallback.run();
        }

        // Close the current stage (window)
        Stage stage = (Stage) saveEditRoomButton.getScene().getWindow();
        stage.close();
    }

    // Get the updated room name from the TextField
    public String getUpdatedRoom() {
        return editRoomField.getText();
    }
}
