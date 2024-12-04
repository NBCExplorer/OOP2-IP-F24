package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Movie;
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
    private Button changeMovieButton, changeRoomButton, saveButton, exitButton;

    private Showtime showToDisplay;

    private ManagerHomeController aManagerHomeController;

    @FXML
    public void initialize() {
        changeMovieButton.setOnAction(event -> openMovieList());
        changeRoomButton.setOnAction(event -> openRoomList());
        saveButton.setOnAction(event -> saveShowtime());
        exitButton.setOnAction(event -> closeWindow());
    }

    public void setShow(Showtime pShowtime) {
        showToDisplay = pShowtime;
        PopulateTextFields();
    }

    private void PopulateTextFields() {
        if (showToDisplay != null) {
            showDateTextField.setText(showToDisplay.getDate());
            showTimeTextField.setText(showToDisplay.getTime());
            showMovieTextField.setText(String.valueOf(showToDisplay.getMovie()));
            showRoomTextField.setText(String.valueOf(showToDisplay.getRoom()));
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
            showToDisplay.setMovie(null);
            showToDisplay.setRoom(null);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Changes saved successfully.");
            alert.show();
        }
        catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Showtime edit error: " + e.getMessage());
            alert.show();
        }
    }

    public void setManagerHomeController(ManagerHomeController pManagerHomeController) {
        this.aManagerHomeController = pManagerHomeController;
    }

    public void closeWindow() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

}
