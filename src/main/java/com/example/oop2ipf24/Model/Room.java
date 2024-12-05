package com.example.oop2ipf24.Model;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String aRoomNumber;

    private List<Room> rooms;

    public Room() {
    }

    public Room(String pRoomNumber, String pDate, String pTime) {
        this.aRoomNumber = pRoomNumber;
    }

    public String getRoomNumber() {
        return this.aRoomNumber;
    }

    public void setRoomNumber(String pRoomNumber) {
        if (pRoomNumber.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Room number cannot be empty or only whitespace.");
            alert.show();
        } else {
            this.aRoomNumber = pRoomNumber;
        }
    }
}
