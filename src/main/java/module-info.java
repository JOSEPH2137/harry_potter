module com.example.harry_potter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.harry_potter to javafx.fxml;
    exports com.example.harry_potter;
}