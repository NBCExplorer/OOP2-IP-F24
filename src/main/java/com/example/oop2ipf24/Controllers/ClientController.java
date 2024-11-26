package com.example.oop2ipf24.Controllers;

import com.example.oop2ipf24.Model.Showtime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientController {

    @FXML
    private TableView<Showtime> showtimeTable;

    @FXML
    private TableColumn<Showtime, String> timeColumn;

    @FXML
    private TableColumn<Showtime, String> dateColumn;

    private ObservableList<Showtime> showtimes;

    @FXML
    public void initialize() {
        // Initialize columns
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time")); // Matches getTime()
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date")); // Matches getDate()

        // Initialize data (example data, replace with your own logic)
        showtimes = FXCollections.observableArrayList(
                new Showtime("12:00 PM", "2024-11-26"),
                new Showtime("3:00 PM", "2024-11-27")
        );

        // Set data in the TableView
        showtimeTable.setItems(showtimes);
    }
}

