package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerHomeController {

    @FXML
    private ListView<String> movieList; // List of movies displayed

    @FXML
    private Button removeMovieButton; // Button to remove movies

    @FXML
    private Button addMovieButton; // Button to add movies

    @FXML
    public void initialize() {
        // Set up the remove button to trigger the delete confirmation
        removeMovieButton.setOnAction(event -> openDeleteConfirmationWindow());

        // Set up the add button to open the Add Movie window
        addMovieButton.setOnAction(event -> openAddMovieWindow());
    }

    /**
     * Opens the delete confirmation window.
     */
    private void openDeleteConfirmationWindow() {
        // Ensure a movie is selected
        String selectedMovie = movieList.getSelectionModel().getSelectedItem();
        if (selectedMovie == null) {
            return; // Do nothing if no movie is selected
        }

        try {
            // Load the DeleteVerifController FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/delete-verification.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows

            // Set up the controller with actions
            DeleteVerifController deleteVerifController = loader.getController();
            deleteVerifController.setOnYes(() -> {
                // Remove the selected movie from the list
                movieList.getItems().remove(selectedMovie);
                stage.close(); // Close the confirmation window
            });

            deleteVerifController.setOnNo(stage::close); // Close the confirmation window on "No"

            stage.setTitle("Delete Confirmation");
            stage.showAndWait(); // Wait until the confirmation window is closed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the Add Movie window.
     */
    private void openAddMovieWindow() {
        try {
            // Load the AddController FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/add-function.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows

            // Pass the current movie list to the AddController
            AddController addController = loader.getController();
            addController.setMovieList(movieList);

            stage.setTitle("Add Movie");
            stage.showAndWait(); // Wait until the Add window is closed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
