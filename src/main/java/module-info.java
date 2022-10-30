module com.osnova.pogoda {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.osnova.pogoda to javafx.fxml;
    exports com.osnova.pogoda;
}