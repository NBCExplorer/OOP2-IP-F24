package com.example.oop2ipf24.Model;

import java.io.Serializable;

/**
 * Represents a client user of the system.
 */
public class Client implements User, Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email;

    /**
     * Creates a new client with the given username, password, and email.
     *
     * @param username the username of the client
     * @param password the password of the client
     * @param email the email of the client
     */
    public Client(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Returns the username of the client.
     *
     * @return the username of the client
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of the client.
     *
     * @return the password of the client
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the email of the client.
     *
     * @return the email of the client
     */
    @Override
    public String getEmail() {
        return email;
    }
}
