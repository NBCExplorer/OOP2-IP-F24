package com.example.oop2ipf24.Model;

public class Showtime {

    private String aTime;
    private String aDate;

    public Showtime(String pTime, String pDate) {
        this.aTime = pTime;
        this.aDate = pDate;
    }

    public String getTime() {
        return this.aTime;
    }

    public void setTime(String pTime) {
        this.aTime = pTime;
    }

    public String getDate() {
        return this.aDate;
    }

    public void setDate(String pDate) {
        this.aDate = pDate;
    }
}
