package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class ClientController {

    @FXML
    private ListView clientListView;

    @FXML
    private Button exitButton;

    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void setClientList() {
        
    }
}
