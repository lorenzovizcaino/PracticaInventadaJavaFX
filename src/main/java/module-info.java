module com.example.practicainventada {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicainventada to javafx.fxml;
    exports com.example.practicainventada;
}