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
    private ListView<String> movieList;

    @FXML
    private ListView<String> roomList;

    @FXML
    private ListView<String> showtimeList;

    @FXML
    private Button addButton;

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

        // Set action for the add button
        addButton.setOnAction(event -> showAddPage());
    }

    private void showDeleteConfirmation() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/delete-verification.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Delete Confirmation");

            DeleteVerifController controller = loader.getController();
            controller.setOnYes(() -> {
                deleteSelectedItem();
                stage.close();
            });
            controller.setOnNo(stage::close);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSelectedItem() {
        if (movieList.getSelectionModel().getSelectedItem() != null) {
            movieList.getItems().remove(movieList.getSelectionModel().getSelectedItem());
        } else if (roomList.getSelectionModel().getSelectedItem() != null) {
            roomList.getItems().remove(roomList.getSelectionModel().getSelectedItem());
        } else if (showtimeList.getSelectionModel().getSelectedItem() != null) {
            showtimeList.getItems().remove(showtimeList.getSelectionModel().getSelectedItem());
        }
    }

    private void showAddPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/add-function.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Item");

            AddController controller = loader.getController();
            controller.setLists(movieList, roomList, showtimeList); // Pass the existing lists to AddController

            stage.showAndWait(); // Wait for user interaction before continuing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
