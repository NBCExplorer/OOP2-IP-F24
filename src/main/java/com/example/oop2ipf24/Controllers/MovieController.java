package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Movie;
import com.example.oop2ipf24.Model.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MovieController {

    @FXML
    private TextField movieNameTextField; // Text field for entering room name

    @FXML
    private Button saveButton; // Add button

    @FXML
    private Button exitButton; // Exit button

    /**
     * Sets the room list reference.
     *
     * @param roomList ListView of rooms from ManagerHomeController
     */

    private Movie movieToDisplay;

    /**
     * Initialize the controller.
     */
    @FXML
    public void initialize() {
        saveButton.setOnAction(event -> saveMovie());
        exitButton.setOnAction(event -> closeWindow());
    }

    public void setMovie(Movie pMovie) {
        movieToDisplay = pMovie;
        PopulateTextFields();
    }

    public void PopulateTextFields() {
        movieNameTextField.setText(movieToDisplay.getName());
    }

    public void saveMovie() {
        try {
            movieToDisplay.setName(movieNameTextField.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Changes saved successfully.");
            alert.show();
        }
        catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Movie edit error: " + e.getMessage());
            alert.show();
        }
    }

    public void closeWindow() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
}