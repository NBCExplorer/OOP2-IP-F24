package com.example.oop2ipf24.Model;

import java.util.ArrayList;
import java.util.List;

public class Room extends Showtime {

    private int aRoomNumber;
    private String aDate;
    private String aTime;

    private List<Room> rooms = new ArrayList<>();

    public Room(int pRoomNumber, String pDate, String pTime) {
        super(pDate, pTime);
        this.aRoomNumber = pRoomNumber;
    }

    public int getRoomNumber() {
        return this.aRoomNumber;
    }

    public void setRoomNumber(int pRoomNumber) {
        this.aRoomNumber = pRoomNumber;
    }
}
