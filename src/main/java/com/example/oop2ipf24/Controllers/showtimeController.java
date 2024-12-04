package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Movie;
import com.example.oop2ipf24.Model.Showtime;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.w3c.dom.Text;
import javafx.scene.control.Button;

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
        PopulateFields();
    }

    private void PopulateFields() {
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
            String showDate = showDateTextField.getText();
            String showTime = showTimeTextField.getText();

            // If editing, update the showtime, otherwise add a new one
            if (showToDisplay != null) {
                showToDisplay.setDate(showDate);
                showToDisplay.setTime(showTime);
            } else {
                Showtime newShowtime = new Showtime(showDate, showTime, null, null);
                Showtime.addShowtime(newShowtime); // Add new showtime to the static list
                aManagerHomeController.addShowToListView(newShowtime); // Add to ListView
            }
        } catch (Exception e) {
            // Handle invalid date/time input
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid date/time format. Please check your input.");
            alert.show();
        }
    }

    public void setManagerHomeController(ManagerHomeController pManagerHomeController) {
        this.aManagerHomeController = pManagerHomeController;
    }

    public void closeWindow() {

    }

}
