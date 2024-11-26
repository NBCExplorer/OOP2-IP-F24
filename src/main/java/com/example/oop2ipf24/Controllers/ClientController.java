package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Showtime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class ClientController {

    @FXML
    private Button backButton;

    @FXML
    private Button myTicketButton;

    @FXML
    private TableView<Showtime> showtimeTable;

    @FXML
    private TableColumn<Showtime, String> showColumn;

    @FXML
    private TableColumn<Showtime, String> timeColumn;

    @FXML
    private void initialize() {
        // Initialize table columns
        showColumn.setCellValueFactory(new PropertyValueFactory<>("show"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        // Add data to the table
        showtimeTable.setItems(getShowtimes());
    }

    // Method to populate the showtime table
    private ObservableList<Showtime> getShowtimes() {
        ObservableList<Showtime> showtimes = FXCollections.observableArrayList();
        showtimes.add(new Showtime("Movie 1", "12:00 PM"));
        showtimes.add(new Showtime("Movie 2", "3:00 PM"));
        showtimes.add(new Showtime("Movie 3", "6:00 PM"));
        return showtimes;
    }

    @FXML
    private void onBack(ActionEvent event) {
        try {
            // Load the login-view.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/login-view.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage (window) and set the new scene
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(loginScene);
            stage.setTitle("Movie Theatre Login");
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception for debugging
            System.err.println("Failed to load login-view.fxml");
        }
    }

    @FXML
    private void onMyTicket(ActionEvent event) {
        // Navigate to the confirmation-view
        System.out.println("My Ticket button clicked.");
        // Add navigation logic for confirmation-view.fxml here
    }
}
