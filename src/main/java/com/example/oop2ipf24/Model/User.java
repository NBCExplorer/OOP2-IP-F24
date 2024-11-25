package com.example.oop2ipf24.Model;

public interface User {
    String getUsername();
    String getPassword();
    String getRole(); // This can return "MANAGER" or "CLIENT"
}
