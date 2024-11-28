package com.example.oop2ipf24.Model;

import java.util.ArrayList;
import java.util.List;

public class Showtime {

    private String aTime;
    private String aDate;

    private Movie aMovie;
    private Room aRoom;

    private List<Showtime> showtimes;
    private List<Movie> movies;
    private List<Room> rooms;

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
        this.aTime = pTime;
    }

    public String getDate() {
        return this.aDate;
    }

    public void setDate(String pDate) {
        this.aDate = pDate;
    }

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

    public void addShowtime(Showtime pShowtime) {
        showtimes.add(pShowtime);
    }

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    public void addMovie(Movie pMovie) {
        movies.add(pMovie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addRoom(Room pRoom) {
        rooms.add(pRoom);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
