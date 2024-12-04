package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Movie;
import com.example.oop2ipf24.Model.Room;
import com.example.oop2ipf24.Model.Showtime;
import com.example.oop2ipf24.MovieApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private ListView<String> roomList; // List of rooms displayed

    @FXML
    private ListView<String> showListView;

    private final ObservableList<Showtime> showObservableList = FXCollections.observableArrayList();
    private final ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();
    private final ObservableList<Room> roomObservableList = FXCollections.observableArrayList();

    @FXML
    private Button removeMovieButton; // Button to remove movies

    @FXML
    private Button addMovieButton; // Button to add movies

    @FXML
    private Button editMovieButton; // Button to edit movies

    @FXML
    private Button showClientList; // Button to show random client list

    @FXML
    private Button addRoomButton; // Add room Button for the text field

    @FXML
    private Button removeRoomButton; // Remove room from the text field

    @FXML
    private Button editRoomButton;

    @FXML
    private Button editShowButton;

    @FXML
    private Button addShowButton;

    @FXML
    private Button removeShowButton;


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

        // Set up the add room button to open the Add Room
        addRoomButton.setOnAction(event -> openAddRoomWindow());

        removeRoomButton.setOnAction(event -> openDeleteConfirmationRoomWindow());

        editRoomButton.setOnAction(event -> openEditRoomWindow());

        editShowButton.setOnAction(event -> openEditShowWindow());

        addShowButton.setOnAction(event -> openAddShowWindow());

        removeShowButton.setOnAction(event -> removeShow());
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
     * Opens the delete confirmation window for a selected item in the provided ListView.
     */
    private void openDeleteConfirmationRoomWindow() {
        // Ensure an item is selected
        String selectedItem = roomList.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return; // Do nothing if no item is selected
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
                // Remove the selected item from the list
                roomList.getItems().remove(selectedItem);
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
            FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/com/example/oop2ipf24/movie-view.fxml"));
            Parent root = fxmlLoader.load();

            MovieController controller = fxmlLoader.getController();
            Movie newMovie = new Movie();
            controller.setMovie(newMovie);

            Scene scene = new Scene(root, 320, 240);
            Stage stage = new Stage();
            stage.setTitle("Add Showtime");
            stage.setScene(scene);
            stage.showAndWait();

            if (newMovie.getName() != null && !newMovie.getName().isEmpty()) {
                movieObservableList.add(newMovie);
                movieList.getItems().add(newMovie.getName());
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Movie addition error: " + e.getMessage());
            alert.show();
        }
    }

    private void openEditMovieWindow() {
        int selectedMovieIndex = movieList.getSelectionModel().getSelectedIndex();
        if (selectedMovieIndex != -1) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/com/example/oop2ipf24/movie-view.fxml"));
                Parent root = fxmlLoader.load();

                MovieController controller = fxmlLoader.getController();
                Movie selectedMovie = movieObservableList.get(selectedMovieIndex);
                controller.setMovie(selectedMovie);

                Scene scene = new Scene(root, 320, 240);
                Stage stage = new Stage();
                stage.setTitle("View & Edit Room");
                stage.setScene(scene);
                stage.showAndWait();

                movieList.getItems().set(selectedMovieIndex, selectedMovie.getName());
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Movie edit error: " + e.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No movie selected to view or edit.");
            alert.show();
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


    private void openAddRoomWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/com/example/oop2ipf24/room-view.fxml"));
            Parent root = fxmlLoader.load();

            RoomController controller = fxmlLoader.getController();
            Room newRoom = new Room();
            controller.setRoom(newRoom);

            Scene scene = new Scene(root, 320, 240);
            Stage stage = new Stage();
            stage.setTitle("Add Room");
            stage.setScene(scene);
            stage.showAndWait();

            if (newRoom.getRoomNumber() != null && !newRoom.getRoomNumber().isEmpty()) {
                roomObservableList.add(newRoom);
                roomList.getItems().add(newRoom.getRoomNumber());
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Room addition error: " + e.getMessage());
            alert.show();
        }
    }

    private void openEditRoomWindow() {
        int selectedRoomIndex = roomList.getSelectionModel().getSelectedIndex();
        if (selectedRoomIndex != -1) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/com/example/oop2ipf24/room-view.fxml"));
                Parent root = fxmlLoader.load();

                RoomController controller = fxmlLoader.getController();
                Room selectedRoom = roomObservableList.get(selectedRoomIndex);
                controller.setRoom(selectedRoom);

                Scene scene = new Scene(root, 320, 240);
                Stage stage = new Stage();
                stage.setTitle("View & Edit Room");
                stage.setScene(scene);
                stage.showAndWait();

                roomList.getItems().set(selectedRoomIndex, selectedRoom.getRoomNumber());
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Room edit error: " + e.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No room selected to view or edit.");
            alert.show();
        }
    }

    // Micah
    private void openEditShowWindow() {
        int selectedShowIndex = showListView.getSelectionModel().getSelectedIndex();
        if (selectedShowIndex != -1) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/com/example/oop2ipf24/showtime-view.fxml"));
                Parent root = fxmlLoader.load();

                showtimeController controller = fxmlLoader.getController();
                Showtime selectedShow = showObservableList.get(selectedShowIndex);
                controller.setShow(selectedShow);

                Scene scene = new Scene(root, 320, 240);
                Stage stage = new Stage();
                stage.setTitle("View & Edit Showtime");
                stage.setScene(scene);
                stage.showAndWait();

                showListView.getItems().set(selectedShowIndex, selectedShow.getDate());
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Showtime edit error: " + e.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No showtime selected to view or edit.");
            alert.show();
        }
    }

    // Micah
    private void openAddShowWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("/com/example/oop2ipf24/showtime-view.fxml"));
            Parent root = fxmlLoader.load();

            showtimeController controller = fxmlLoader.getController();
            Showtime newShow = new Showtime();
            controller.setShow(newShow);

            Scene scene = new Scene(root, 320, 240);
            Stage stage = new Stage();
            stage.setTitle("Add Showtime");
            stage.setScene(scene);
            stage.showAndWait();

            if (newShow.getDate() != null && !newShow.getDate().isEmpty()) {
                showObservableList.add(newShow);
                showListView.getItems().add(newShow.getDate());
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Showtime addition error: " + e.getMessage());
            alert.show();
        }
    }

    // Micah
    private void removeShow() {
        int selectedIndex = showListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            Showtime removedShow = showObservableList.get(selectedIndex);
            showObservableList.remove(removedShow);
            showListView.getItems().remove(selectedIndex);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Showtime removed successfully.");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No showtime selected to remove.");
            alert.show();
        }
    }
}
