package com.example.oop2ipf24.Model;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String aName;

    public Movie(String pName) {
        this.aName = pName;
    }

    public String getName() {
        return this.aName;
    }

    public void setName(String pName) {
        this.aName = pName;
    }
}
