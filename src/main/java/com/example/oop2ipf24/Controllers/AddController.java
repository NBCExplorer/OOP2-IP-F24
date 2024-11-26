package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {

    @FXML
    private TextField movieText; // Input field for movie name

    @FXML
    private Button addFunctions; // Button to add the movie

    @FXML
    private Button exitaddButton; // Button to exit without adding

    private ListView<String> movieList; // Reference to the movie list from ManagerHomeController

    @FXML
    public void initialize() {
        // Add button action: Add the movie to the list and close the window
        addFunctions.setOnAction(event -> {
            if (movieList != null && !movieText.getText().trim().isEmpty()) {
                movieList.getItems().add(movieText.getText().trim());
            }
            closeWindow();
        });

        // Exit button action: Close the window without adding
        exitaddButton.setOnAction(event -> closeWindow());
    }

    /**
     * Sets the reference to the movie ListView from the main controller.
     *
     * @param movieList The ListView to update with the new movie
     */
    public void setMovieList(ListView<String> movieList) {
        this.movieList = movieList;
    }

    /**
     * Closes the current window.
     */
    private void closeWindow() {
        Stage stage = (Stage) addFunctions.getScene().getWindow();
        stage.close();
    }
}
