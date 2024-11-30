package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class AddRoomController {

    @FXML
    private TextField addRoomText; // Text field for entering room name

    @FXML
    private Button addRoomButton1; // Add button

    @FXML
    private Button exitRoomButton; // Exit button

    private ListView<String> roomList; // Reference to the room list in ManagerHomeController

    /**
     * Sets the room list reference.
     *
     * @param roomList ListView of rooms from ManagerHomeController
     */
    public void setRoomList(ListView<String> roomList) {
        this.roomList = roomList;
    }

    /**
     * Initialize the controller.
     */
    @FXML
    public void initialize() {
        // Add button action to add the room to the room list
        addRoomButton1.setOnAction(event -> {
            String roomName = addRoomText.getText().trim();
            if (!roomName.isEmpty() && roomList != null) {
                roomList.getItems().add(roomName); // Add room name to the room list
            }

            // Close the window after adding
            Stage stage = (Stage) addRoomButton1.getScene().getWindow();
            stage.close();
        });

        // Exit button action to close the window without saving
        exitRoomButton.setOnAction(event -> {
            Stage stage = (Stage) exitRoomButton.getScene().getWindow();
            stage.close();
        });
    }
}
