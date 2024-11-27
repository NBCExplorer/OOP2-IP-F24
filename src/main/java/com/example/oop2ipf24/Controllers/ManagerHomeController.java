package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ManagerHomeController {

    @FXML
    private ListView<String> movieList; // List of movies displayed

    @FXML
    private Button removeMovieButton; // Button to remove movies

    @FXML
    private Button addMovieButton; // Button to add movies

    @FXML
    private Button editMovieButton; // Button to edit movies

    @FXML
    private Button showClientList; // Button to show random client list

    @FXML
    public void initialize() {
        // Set up the remove button to trigger the delete confirmation
        removeMovieButton.setOnAction(event -> openDeleteConfirmationWindow());

        // Set up the add button to open the Add Movie window
        addMovieButton.setOnAction(event -> openAddMovieWindow());

        // Set up the edit button to open the Edit Movie window
        editMovieButton.setOnAction(event -> openEditMovieWindow());

        // Set up the button to show the random client list
        showClientList.setOnAction(event -> showClientListInNewWindow());
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

    private void openEditMovieWindow() {
        String selectedMovie = movieList.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            try {
                // Load the edit movie FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/edit-function.fxml"));
                Parent root = loader.load();

                // Get the edit controller and set the movie title
                editController controller = loader.getController();
                controller.setMovie(selectedMovie);

                // Define the callback to update the movie list
                controller.setOnSaveCallback(() -> {
                    String updatedMovie = controller.getUpdatedMovie(); // Get the updated title from the text field
                    if (updatedMovie != null && !updatedMovie.isEmpty()) {
                        int selectedIndex = movieList.getSelectionModel().getSelectedIndex();
                        movieList.getItems().set(selectedIndex, updatedMovie); // Replace the movie title in the ListView
                    }
                });

                // Show the edit window
                Stage stage = new Stage();
                stage.setTitle("Edit Movie");
                stage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows
                stage.setScene(new Scene(root));
                stage.showAndWait(); // Wait until the edit window is closed

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No movie selected to edit.");
        }
    }

    /**
     * Shows the random list of client names in a new window.
     */
    private void showClientListInNewWindow() {

        String[] clientNames = {
                "Alice Johnson",
                "Michael Brown",
                "Emily Davis",
                "David Wilson",
                "Sophia Miller",
                "Daniel Martinez",
                "Charlotte Anderson",
                "Matthew Thompson",
                "Ava Rodriguez",
                "James White"
        };

        // Shuffle the client names array to create a random order
        List<String> randomClientList = Arrays.asList(clientNames);
        Collections.shuffle(randomClientList);

        // Create a new ListView to show the random list
        ListView<String> clientListView = new ListView<>();
        clientListView.getItems().setAll(randomClientList);

        // Create a new Stage (window)
        Stage clientListStage = new Stage();
        clientListStage.setTitle("Very real client list, 100% real people, not chatGPT generated list, Completly real");

        // Create a new Scene and add the ListView to it
        Scene clientListScene = new Scene(clientListView, 300, 400);
        clientListStage.setScene(clientListScene);

        // Show the new window
        clientListStage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows
        clientListStage.showAndWait();
    }
}
