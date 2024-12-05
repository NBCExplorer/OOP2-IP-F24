package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Movie;
import com.example.oop2ipf24.Model.Room;
import com.example.oop2ipf24.Model.Showtime;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;

public class showtimeController {

    @FXML
    private TextField showDateTextField, showTimeTextField;

    @FXML
    private TextField showMovieTextField, showRoomTextField;

    @FXML
    private Button saveButton, exitButton;

    private Showtime showToDisplay;
    private Movie showMovie;
    private Room showRoom;

    @FXML
    public void initialize() {
        saveButton.setOnAction(event -> saveShowtime());
        exitButton.setOnAction(event -> closeWindow());
    }

    public void setShow(Showtime pShowtime, Movie pMovie, Room pRoom) {
        showToDisplay = pShowtime;
        showMovie = pMovie;
        showRoom = pRoom;
        PopulateTextFields();
    }

    private void PopulateTextFields() {
        if (showToDisplay != null) {
            showDateTextField.setText(showToDisplay.getDate());
            showTimeTextField.setText(showToDisplay.getTime());
            showMovieTextField.setText(showMovie.getName());
            showRoomTextField.setText(showRoom.getRoomNumber());
        }
    }

    public void openMovieList() {

    }

    public void openRoomList() {

    }

    public void saveShowtime() {
        try {
            showToDisplay.setDate(showDateTextField.getText());
            showToDisplay.setTime(showTimeTextField.getText());
            showToDisplay.setMovie(showMovie);
            showToDisplay.setRoom(showRoom);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Changes saved successfully.");
            alert.show();
        }
        catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Showtime edit error: " + e.getMessage());
            alert.show();
        }
    }

    public void closeWindow() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

}
