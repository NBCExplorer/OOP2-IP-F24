module com.example.oop2ipf24 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop2ipf24 to javafx.fxml;
    exports com.example.oop2ipf24;
}