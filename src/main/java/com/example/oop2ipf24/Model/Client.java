package com.example.oop2ipf24.Model;

public class Client implements User {
    private String username;
    private String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void performRoleSpecificAction() {
        // Implement client-specific actions here
    }
}
