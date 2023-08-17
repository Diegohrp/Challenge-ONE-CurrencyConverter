module com.personal.converter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.personal.converter to javafx.fxml;
    opens com.personal.converter.controllers to javafx.fxml;
    exports com.personal.converter;
    exports com.personal.converter.controllers;
    exports com.personal.converter.models;
    exports com.personal.converter.enums;
    exports com.personal.converter.interfaces;

}