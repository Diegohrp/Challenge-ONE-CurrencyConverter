package com.personal.converter.controllers;

import com.personal.converter.enums.Temperatures;
import com.personal.converter.models.TemperatureConverter;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class TempViewController extends Controller implements Initializable {

    @Override public void initialize(URL location, ResourceBundle resources){
        TemperatureConverter converter = new TemperatureConverter();
        this.startConverter(Temperatures.values(),converter);
    }
}
