package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.io.IOException;

public class ManagerHomeController {

    @FXML
    private ListView<String> movieList;

    @FXML
    private ListView<String> roomList;

    @FXML
    private ListView<String> showtimeList;

    @FXML
    private Button removeButton;

    @FXML
    public void initialize() {
        // Example items for the ListViews
        movieList.getItems().addAll("Movie 1", "Movie 2", "Movie 3");
        roomList.getItems().addAll("Room A", "Room B", "Room C");
        showtimeList.getItems().addAll("10:00 AM", "12:00 PM", "3:00 PM");

        // Set action for the remove button
        removeButton.setOnAction(event -> showDeleteConfirmation());
    }

    private void showDeleteConfirmation() {
        try {
            // Load the Delete Confirmation FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/delete-verification.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows until closed
            stage.setTitle("Delete Confirmation");

            // Access the DeleteVerifController to set up actions
            DeleteVerifController controller = loader.getController();
            controller.setOnYes(() -> {
                deleteSelectedItem(); // Delete item if "Yes" is clicked
                stage.close();        // Close the confirmation window
            });
            controller.setOnNo(stage::close); // Close the window if "No" is clicked

            stage.showAndWait(); // Show the dialog and wait for user interaction
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSelectedItem() {
        // Remove the selected item from the respective ListView
        if (movieList.getSelectionModel().getSelectedItem() != null) {
            movieList.getItems().remove(movieList.getSelectionModel().getSelectedItem());
        } else if (roomList.getSelectionModel().getSelectedItem() != null) {
            roomList.getItems().remove(roomList.getSelectionModel().getSelectedItem());
        } else if (showtimeList.getSelectionModel().getSelectedItem() != null) {
            showtimeList.getItems().remove(showtimeList.getSelectionModel().getSelectedItem());
        }
    }
}
