package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Room;
import com.example.oop2ipf24.Model.Showtime;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class RoomController {

    @FXML
    private TextField roomIDTextField; // Text field for entering room name

    @FXML
    private Button saveButton; // Add button

    @FXML
    private Button exitButton; // Exit button

    private ListView<String> roomList; // Reference to the room list in ManagerHomeController

    /**
     * Sets the room list reference.
     *
     * @param roomList ListView of rooms from ManagerHomeController
     */
    public void setRoomList(ListView<String> roomList) {
        this.roomList = roomList;
    }

    private Room roomToDisplay;

    /**
     * Initialize the controller.
     */
    @FXML
    public void initialize() {
        saveButton.setOnAction(event -> saveRoom());
        exitButton.setOnAction(event -> closeWindow());
    }

    public void setRoom(Room pRoom) {
        roomToDisplay = pRoom;
        PopulateTextFields();
    }

    public void PopulateTextFields() {
        roomIDTextField.setText(roomToDisplay.getRoomNumber());
    }

    public void saveRoom() {
        try {
            roomToDisplay.setRoomNumber(roomIDTextField.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Changes saved successfully.");
            alert.show();
        }
        catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Room edit error: " + e.getMessage());
            alert.show();
        }
    }

    public void closeWindow() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
}
