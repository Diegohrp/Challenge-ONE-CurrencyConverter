package com.personal.converter.controllers;

import com.personal.converter.enums.Lengths;
import com.personal.converter.models.Measurement;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LengthViewController extends Controller implements Initializable {

    @Override public void initialize(URL location, ResourceBundle resources){
        final ArrayList<Measurement> lengthOptions = new ArrayList<>();
        Arrays.stream(Lengths.values()).forEach(obj->lengthOptions.add(obj.getObjFromEnum()));
        this.initComponents(lengthOptions);
    }
}
