package com.personal.converter.controllers;

import com.personal.converter.enums.Coins;
import com.personal.converter.models.CoinsConverter;
import com.personal.converter.models.Measurement;
import com.personal.converter.utils.Utils;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CoinsViewController extends Controller implements Initializable {

    @Override public void initialize(URL location, ResourceBundle resources){
        ArrayList<Measurement> coinsOptions = new ArrayList<>();
        Arrays.stream(Coins.values()).forEach(c -> coinsOptions.add(c.getObjFromEnum()));
        this.setOptionsWithImg(coinsOptions);
        this.initComponents(coinsOptions);
        this.getTextInput().textProperty().addListener(
            (observable, oldValue, newValue) -> {
                Utils.validateTextField(Utils.validatePositiveDecimal(newValue),
                    this.getErrorLabel(), this.getTextInputContainer(),
                    this.getConvertBtn());
            });
        this.setConverter(new CoinsConverter(coinsOptions.get(0)));
    }
}