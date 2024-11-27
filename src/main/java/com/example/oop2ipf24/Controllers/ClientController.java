package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Showtime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientController {

    @FXML
    private TableView<Showtime> showtimeTable;

    @FXML
    private TableColumn<Showtime, String> timeColumn;

    @FXML
    private TableColumn<Showtime, String> dateColumn;

    @FXML
    private Button backButton;

    @FXML
    private Button buyTicketButton;

    @FXML
    public void initialize() {
        // Initialize columns
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time")); // Matches getTime()
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date")); // Matches getDate()

        // Initialize data (example data, replace with your own logic)
        ObservableList<Showtime> showtimes = FXCollections.observableArrayList(
        );

        // Set data in the TableView
        showtimeTable.setItems(showtimes);
    }

    @FXML
    private void handleBackButton() {
        navigateTo("/com/example/oop2ipf24/login-view.fxml", "Login");
    }

    @FXML
    private void handleBuyTicketButton() {
        navigateTo("/com/example/oop2ipf24/confirmation-view.fxml", "Ticket Confirmation");
    }

    private void navigateTo(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile)); // fxmlFile is already the full path
            Parent root = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow(); // Use backButton to get the stage
            stage.setScene(new Scene(root));
            stage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + fxmlFile);
        }
    }

}

