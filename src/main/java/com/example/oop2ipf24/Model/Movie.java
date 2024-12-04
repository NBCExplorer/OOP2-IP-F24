package com.example.oop2ipf24.Model;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String aName;

    private List<Movie> movies;

    public Movie(){
    }

    public Movie(String pName) {
        this.aName = pName;
    }

    public String getName() {
        return this.aName;
    }

    public void setName(String pName) {
        this.aName = pName;
    }

    public void addMovie(Movie pMovie) {
        movies.add(pMovie);
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
