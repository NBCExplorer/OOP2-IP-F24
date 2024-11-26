package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {

    @FXML
    private TextField movieText;

    @FXML
    private TextField roomText;

    @FXML
    private TextField timeText;

    @FXML
    private Button addFunctions;

    @FXML
    private Button exitaddButton;

    private ListView<String> movieList;
    private ListView<String> roomList;
    private ListView<String> showtimeList;

    @FXML
    public void initialize() {
        // Add button action
        addFunctions.setOnAction(event -> {
            // Add values from text fields to the respective lists
            if (!movieText.getText().trim().isEmpty()) {
                movieList.getItems().add(movieText.getText().trim());
            }
            if (!roomText.getText().trim().isEmpty()) {
                roomList.getItems().add(roomText.getText().trim());
            }
            if (!timeText.getText().trim().isEmpty()) {
                showtimeList.getItems().add(timeText.getText().trim());
            }
            // Close the Add window after adding items
            ((Stage) addFunctions.getScene().getWindow()).close();
        });

        // Exit button action
        exitaddButton.setOnAction(event -> {
            ((Stage) exitaddButton.getScene().getWindow()).close();
        });
    }

    /**
     * Set the existing ListViews for movies, rooms, and showtimes.
     *
     * @param movieList    ListView for movies
     * @param roomList     ListView for rooms
     * @param showtimeList ListView for showtimes
     */
    public void setLists(ListView<String> movieList, ListView<String> roomList, ListView<String> showtimeList) {
        this.movieList = movieList;
        this.roomList = roomList;
        this.showtimeList = showtimeList;
    }
}
