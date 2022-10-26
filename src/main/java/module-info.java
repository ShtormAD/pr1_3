module com.example.pr1_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pr1_3 to javafx.fxml;
    exports com.example.pr1_3;
}