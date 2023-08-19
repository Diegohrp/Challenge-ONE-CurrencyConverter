package com.personal.converter.controllers;

import com.personal.converter.enums.Lengths;
import com.personal.converter.models.LengthConverter;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LengthViewController extends Controller implements Initializable {

    @Override public void initialize(URL location, ResourceBundle resources){
        LengthConverter converter = new LengthConverter();
        this.startConverter(Lengths.values(),converter);
    }
}
