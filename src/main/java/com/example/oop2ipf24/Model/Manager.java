package com.example.oop2ipf24.Model;

public class Manager implements User {
    private String username;
    private String password;

    public Manager(String username, String password) {
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
        // Implement manager-specific actions here
    }

    public void manageTheatre() {
        System.out.println("Manager is managing the theatre...");
    }
}
