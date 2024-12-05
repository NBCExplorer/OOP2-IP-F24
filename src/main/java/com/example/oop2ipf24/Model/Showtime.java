package com.example.oop2ipf24.Model;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class Showtime {

    private String aTime;
    private String aDate;

    private Movie aMovie;
    private Room aRoom;

    private static List<Showtime> showtimes;

    public Showtime() {
    }

    public Showtime(String pTime, String pDate, Movie pMovie, Room pRoom) {
        this.aTime = pTime;
        this.aDate = pDate;
        this.aMovie = pMovie;
        this.aRoom = pRoom;
    }

    public String getTime() {
        return this.aTime;
    }

    public void setTime(String pTime) {
        if (pTime.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Time cannot be empty or only whitespace.");
            alert.show();
        } else {
            this.aTime = pTime;
        }
    }

    public String getDate() {
        return this.aDate;
    }

    public void setDate(String pDate) {
        if (pDate.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Date cannot be empty or only whitespace.");
            alert.show();
        } else {
            this.aDate = pDate;
        }    }

    public Movie getMovie() {
        return this.aMovie;
    }

    public void setMovie(Movie pMovie) {
        this.aMovie = pMovie;
    }

    public Room getRoom() {
        return this.aRoom;
    }

    public void setRoom(Room pRoom) {
        this.aRoom = pRoom;
    }
}
