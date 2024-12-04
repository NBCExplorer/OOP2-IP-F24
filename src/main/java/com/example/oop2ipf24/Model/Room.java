package com.example.oop2ipf24.Model;

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
        this.aRoomNumber = pRoomNumber;
    }

    public void addRoom(Room pRoom) {
        rooms.add(pRoom);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
