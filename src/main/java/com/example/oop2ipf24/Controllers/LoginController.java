package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Client;
import com.example.oop2ipf24.Model.Manager;
import com.example.oop2ipf24.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public static Map<String, User> users = new HashMap<>();
    public static String currentUser; // Add this field to track the current user

    static {
        loadUsers();
    }

    public static void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            users = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LoginController() {
        if (users.isEmpty()) {
            users.put("manager1", new Manager("manager1", "password1", "manager1@example.com"));
            users.put("client1", new Client("client1", "password2", "client1@example.com"));
        }
    }

    @FXML
    private void onLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User authenticatedUser = authenticateUser(username, password);

        if (authenticatedUser != null) {
            currentUser = username; // Set the current user
            if (authenticatedUser instanceof Manager) {
                navigateTo("/com/example/oop2ipf24/manager.fxml", "Manager Dashboard", event);
            } else if (authenticatedUser instanceof Client) {
                navigateTo("/com/example/oop2ipf24/client-view.fxml", "Client Dashboard", event);
            }
        } else {
            showError("Invalid login credentials! Please try again.");
        }
    }

    private User authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    private void navigateTo(String fxmlFile, String title, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showError("Failed to load the requested view: " + fxmlFile);
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onSignUp(ActionEvent event) {
        navigateTo("/com/example/oop2ipf24/signup-view.fxml", "Sign Up", event);
    }

    @FXML
    private void onClose(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

