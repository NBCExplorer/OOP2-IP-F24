package com.example.oop2ipf24.Model;

public class Room extends Showtime {

    private int aRoomNumber;
    private String aDate;
    private String aTime;

    public Room(int pRoomNumber, String pDate, String pTime) {
        super(pDate, pTime);
        this.aRoomNumber = pRoomNumber;
    }
}
