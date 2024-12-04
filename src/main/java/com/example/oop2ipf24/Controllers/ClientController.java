package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Client;
import com.example.oop2ipf24.Model.Movie;
import com.example.oop2ipf24.Model.Room;
import com.example.oop2ipf24.Model.Showtime;
import com.example.oop2ipf24.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientController {

    @FXML
    private ListView<String> movieList;

    @FXML
    private ListView<String> roomList;

    @FXML
    private ListView<Showtime> showtimeList;

    @FXML
    private Button backButton;

    @FXML
    private Button buyTicketButton;

    @FXML
    public void initialize() {
        // Initialize data (example data, replace with your own logic)
        ObservableList<String> movies = FXCollections.observableArrayList("Movie 1", "Movie 2", "Movie 3");
        ObservableList<String> rooms = FXCollections.observableArrayList("Room 1", "Room 2", "Room 3");

        // Create example Movie and Room objects
        Movie exampleMovie = new Movie("Example Movie");
        Room exampleRoom = new Room(1, "Example Room", "Description");

        ObservableList<Showtime> showtimes = FXCollections.observableArrayList(
                new Showtime("10:00 AM", "2023-10-01", exampleMovie, exampleRoom),
                new Showtime("12:00 PM", "2023-10-01", exampleMovie, exampleRoom),
                new Showtime("02:00 PM", "2023-10-01", exampleMovie, exampleRoom)
        );

        // Set data in the ListView
        movieList.setItems(movies);
        roomList.setItems(rooms);
        showtimeList.setItems(showtimes);
    }

    @FXML
    private void handleBackButton() {
        navigateTo("/com/example/oop2ipf24/login-view.fxml");
    }

    @FXML
    private void handleBuyTicketButton() {
        User user = LoginController.users.get(LoginController.currentUser); // Use the current logged-in user
        if (user instanceof Client) {
            Client client = (Client) user;
            String clientEmail = client.getEmail();
            navigateToConfirmationView(clientEmail);
        } else {
            System.err.println("Error: No current user found or user is not a client.");
        }
    }

    private void navigateTo(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + fxmlFile);
        }
    }

    private void navigateToConfirmationView(String email) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/oop2ipf24/confirmation-view.fxml"));
            Parent root = loader.load();

            ConfirmationController confirmationController = loader.getController();
            confirmationController.setClientEmail(email);

            Stage stage = (Stage) buyTicketButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Ticket Confirmation");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: /confirmation-view.fxml");
        }
    }
}
