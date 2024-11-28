package com.example.oop2ipf24.Model;


/**
 * Represents a client user of the system.
 */
public class Client implements User {
    private String username;
    private String password;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Get the username of the client.
     * @return The username of the client.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Get the password of the client.
     * @return The password of the client.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Perform role-specific actions for the client.
     */
    @Override
    public void performRoleSpecificAction() {
        // Implement client-specific actions here
    }
}
