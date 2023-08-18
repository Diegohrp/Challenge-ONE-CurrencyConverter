package com.personal.converter.controllers;

import com.personal.converter.enums.Lengths;
import com.personal.converter.models.LengthConverter;
import com.personal.converter.models.Measurement;
import com.personal.converter.utils.Utils;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LengthViewController extends Controller implements Initializable {

    @Override public void initialize(URL location, ResourceBundle resources){
        final ArrayList<Measurement> lengthOptions = new ArrayList<>();
        Arrays.stream(Lengths.values()).forEach(
            obj -> lengthOptions.add(obj.getObjFromEnum()));
        this.initComponents(lengthOptions);
        this.getTextInput().textProperty().addListener(
            (observable, oldValue, newValue) -> {
                Utils.validateTextField(Utils.validatePositiveDecimal(newValue),
                    this.getErrorLabel(), this.getTextInputContainer(),
                    this.getConvertBtn());
            });
        this.setConverter(new LengthConverter(lengthOptions.get(0)));
    }
}
