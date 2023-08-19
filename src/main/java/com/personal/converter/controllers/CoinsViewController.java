package com.personal.converter.controllers;

import com.personal.converter.enums.Coins;
import com.personal.converter.models.CoinsConverter;
import javafx.fxml.Initializable;
import java.net.URL;

import java.util.ResourceBundle;

public class CoinsViewController extends Controller implements Initializable {

    @Override public void initialize(URL location, ResourceBundle resources){
        CoinsConverter converter = new CoinsConverter();
        this.startConverter(Coins.values(),converter);
    }
}