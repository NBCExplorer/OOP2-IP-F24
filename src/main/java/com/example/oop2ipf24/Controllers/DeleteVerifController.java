package com.example.oop2ipf24.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DeleteVerifController {

    @FXML
    private Button yesDelete;

    @FXML
    private Button noDelete;

    private Runnable onYes; // Action to perform when "Yes" is clicked
    private Runnable onNo;  // Action to perform when "No" is clicked

    @FXML
    public void initialize() {
        yesDelete.setOnAction(event -> {
            if (onYes != null) onYes.run(); // Trigger the "Yes" action
        });

        noDelete.setOnAction(event -> {
            if (onNo != null) onNo.run(); // Trigger the "No" action
        });
    }

    public void setOnYes(Runnable onYes) {
        this.onYes = onYes;
    }

    public void setOnNo(Runnable onNo) {
        this.onNo = onNo;
    }
}
