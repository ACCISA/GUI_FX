module com.fxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens com.fxproject to javafx.fxml;
    opens com.fxproject.Controllers to javafx.fxml;
    exports com.fxproject;
    exports com.fxproject.Controllers;
    exports com.fxproject.Controllers.ColumnData;
}