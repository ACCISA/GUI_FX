module com.fxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens com.fxproject to javafx.fxml;
    exports com.fxproject;
}