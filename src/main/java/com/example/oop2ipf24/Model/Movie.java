package com.example.oop2ipf24.Model;

import java.util.ArrayList;
import java.util.List;

public class Movie extends Showtime {

    private String aName;
    private String pTime;
    private String pDate;

    private List<Movie> movies = new ArrayList<>();

    public Movie(String pName, String pTime, String pDate) {
        super(pTime, pDate);
        this.aName = pName;
    }

    public String getName() {
        return this.aName;
    }

    public void setName(String pName) {
        this.aName = pName;
    }
}
