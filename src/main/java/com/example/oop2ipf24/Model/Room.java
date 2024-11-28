package com.example.oop2ipf24.Model;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int aRoomNumber;
    private List<Room> rooms;

    public Room(int pRoomNumber, String pDate, String pTime) {
        this.aRoomNumber = pRoomNumber;
    }

    public int getRoomNumber() {
        return this.aRoomNumber;
    }

    public void setRoomNumber(int pRoomNumber) {
        this.aRoomNumber = pRoomNumber;
    }
}
