package com.example.oop2ipf24.Model;

/**
 * Represents a manager user of the system.
 */
public class Manager implements User {
    private String username;
    private String password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Get the username of the manager.
     * @return The username of the manager.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Get the password of the manager.
     * @return The password of the manager.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Perform role-specific actions for the manager.
     */
    @Override
    public void performRoleSpecificAction() {
        // Implement manager-specific actions here
    }

    public void manageTheatre() {
        System.out.println("Manager is managing the theatre...");
    }
}
