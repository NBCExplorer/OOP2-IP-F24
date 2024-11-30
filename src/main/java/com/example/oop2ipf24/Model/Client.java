package com.example.oop2ipf24.Model;

import java.io.Serializable;

/**
 * Represents a client user of the system.
 */
public class Client implements User, Serializable {
    private static final long serialVersionUID = 1L;
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
