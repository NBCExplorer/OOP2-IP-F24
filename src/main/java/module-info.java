module com.example.oop2ipf24 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;


    opens com.example.oop2ipf24 to javafx.fxml;
    exports com.example.oop2ipf24;
    opens com.example.oop2ipf24.Controllers to javafx.fxml;
    exports com.example.oop2ipf24.Controllers;
}