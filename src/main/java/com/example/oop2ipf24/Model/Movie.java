package com.example.oop2ipf24.Model;

import javafx.scene.control.Alert;

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
        if (pName.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Movie name cannot be empty or only whitespace.");
            alert.show();
        } else {
            this.aName = pName;
        }
    }
}
