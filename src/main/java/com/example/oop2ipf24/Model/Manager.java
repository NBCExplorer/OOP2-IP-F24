package com.example.oop2ipf24.Model;

import java.io.Serializable;

/**
 * Represents a manager user of the system.
 */
public class Manager implements User, Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email;


    /**
     * Creates a new manager with the given username, password, and email.
     *
     * @param username the username of the manager
     * @param password the password of the manager
     * @param email the email of the manager
     */
    public Manager(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Returns the username of the manager.
     *
     * @return the username of the manager
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of the manager.
     *
     * @return the password of the manager
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the email of the manager.
     *
     * @return the email of the manager
     */
    @Override
    public String getEmail() {
        return email;
    }
}